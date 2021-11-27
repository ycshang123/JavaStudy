package top.ycshang.basedao.thread;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-28 00:32
 **/
@SuppressWarnings("resource")
public class Down {
    /**
     * 配置线程池
     */
    int threadSize = 4;
    private final ExecutorService threads = Executors.newFixedThreadPool(threadSize);
    CountDownLatch latch = new CountDownLatch(0);

    static final String FILE_ACCESS_MODE = "rwd";
    /**
     * http连接源
     */
    String source;
    /**
     * 本地文件下载的路径
     */
    String dir = "D:\\images";
    /**
     * 待下载的文件名
     */
    String fileName;
    /**
     * 本地记录进度的 temp 文件
     */
    String tempFileName;

    /**
     * 文件切片大小（单位M）
     */
    static final int LEN = 1024 * 1024 * 6;
    /**
     * 已被使用
     */
    private final Set<Integer> used = new HashSet<>();
    /**
     * 待做任务
     */
    private final Set<Integer> todo = new HashSet<>();

    /**
     * 切片数据，给 URL 分片去拉数据
     */
    private final Map<Integer, String> ranges = new HashMap<>();

    /**
     * 通过 URL 获取连接
     * @return http连接
     * @throws Exception 异常
     */
    private HttpURLConnection getConn() throws Exception {
        URL url = new URL(source);
        return (HttpURLConnection) url.openConnection();
    }

    private static String getFileNameFromPath(String path) {
        String[] dirs = path.split("/");
        return dirs[dirs.length - 1];
    }

    private String getLocalPath() {
        return dir + fileName;
    }

    public Down(String source) {
        this(source, getFileNameFromPath(source));
    }

    public Down(String source, String fileName) {
        this.source = source;
        this.fileName = fileName;
        // 缓存文件，进度记录
        this.tempFileName = getLocalPath() + ".temp";
        init();
    }

    /**
     * 判断文件是否成功下载
     * @return boolean
     */
    private boolean isPresent() {
        return new File(getLocalPath()).exists() && !new File(tempFileName).exists();
    }

    /**
     * 初始化操作
     */
    private void init() {
        if (isPresent()) {
            System.out.printf("[%s] 文件已经成功下载", fileName);
            return;
        }
        try {
            System.out.println("===> 创建本地文件");
            createLocalFileIfNotExist();
            System.out.println("===> 创建进度记录文件");
            processProgressFile();
            System.out.println("===> 文件切片处理");
            createDownIndexBySplit();
            System.out.println("===> 初始化结束");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 生成本地目标文件，如果不存在
     * @throws Exception 异常
     */
    private void createLocalFileIfNotExist() throws Exception {
        File file = new File(getLocalPath());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            RandomAccessFile accessFile = new RandomAccessFile(file, FILE_ACCESS_MODE);
            accessFile.setLength(getConn().getContentLengthLong());
        }
    }

    /**
     * 处理本地进度记录文件
     * @throws IOException 异常
     */
    private void processProgressFile() throws IOException {
        File temp = new File(tempFileName);
        if (!temp.exists()) {
            // 没有就创建
            temp.createNewFile();
        } else {
            // 存在则更新已下载的索引数据
            BufferedReader bufferedReader = new BufferedReader(new FileReader(temp));
            String str = bufferedReader.readLine();
            if (str == null) {
                return;
            }
            bufferedReader.close();
            for (String s : str.split(",")) {
                used.add(Integer.valueOf(s));
            }
        }
    }

    /**
     * 切割文件拿到索引
     * @throws Exception 异常
     */
    private void createDownIndexBySplit() throws Exception {
        int fileLen = getConn().getContentLength();
        // [0, 9] [10, 19]
        for (int i = (int) (fileLen / LEN); i >= 0; i--) {
            ranges.put(i, "bytes=" + i * LEN + "-" + Math.min(fileLen + 1, (i + 1) * LEN));
            // System.out.println(ranges.get(i));
        }
        todo.addAll(ranges.keySet());
        // 去掉已经下过的索引
        todo.removeAll(used);
        latch = new CountDownLatch(todo.size());
    }

    /**
     * 以多线程的方式来写文件
     */
    public void down() {
        todo.forEach(i -> threads.execute(new DownThread(i)));
        threads.shutdown();
        try {
            latch.await();
            new File(tempFileName).deleteOnExit();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    class DownThread implements Runnable {
        Integer index;
        byte[] bs = new byte[1024 * 128];
        DownThread(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection conn = getConn();
                // 设置切片文件位置
                conn.setRequestProperty("Range", ranges.get(index));
                // 给当前请求伪造User-Agent头，防止被 403
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0");
                RandomAccessFile fos = new RandomAccessFile(getLocalPath(), FILE_ACCESS_MODE);
                // 读、写文件同步偏移
                fos.seek((long) LEN * index);
                // 写操作
                InputStream is = conn.getInputStream();
                int read;
                while ((read = is.read(bs)) != -1) {
                    fos.write(bs, 0, read);
                }
                fos.close();
                conn.disconnect();
                synchronized (Down.class) {
                    latch.countDown();
                    // 更新索引
                    used.add(index);
                    System.out.printf("当前文件：[%s], 下载片段：[%d], 进度：[%d %%] \n", fileName, index, used.size() * 100 / ranges.keySet().size());
                    try {
                        // 更新到文件
                        String memo = used.stream().map(Object::toString).collect(Collectors.joining(","));
                        Files.write(Paths.get(tempFileName), memo.getBytes());
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long begin  = System.currentTimeMillis();
        Down down1 = new Down("https://download.oracle.com/java/17/latest/jdk-17_macos-x64_bin.dmg");
        down1.down();
        long end  = System.currentTimeMillis();
        System.out.println("下载耗时：" + (end - begin) / 1000 / 60.0 + "分钟");
    }
}