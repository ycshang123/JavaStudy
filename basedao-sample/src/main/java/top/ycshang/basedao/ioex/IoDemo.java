package top.ycshang.basedao.ioex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 19:02
 **/
public class IoDemo {
    public static void main(String[] args) throws Exception {
        //characterDemo();
        //transferDemo();
        //transferReader();
        //fileWriterDemo();
        //fileReaderDemo();
        //bufferWriterDemo();
        bufferReaderDemo();
        //txtSort();
        //printWriterDemo();
        //writeObjectDemo();
        //readObjectDemo();
    }

    /**
     * getBytes()使用默认字符集将String编码转为字节序列
     *
     * @throws Exception
     */
    public static void characterDemo() throws Exception {
        byte[] bytes = "你".getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));
        bytes = "你".getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
        bytes = "你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(bytes));
        bytes = "你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(bytes);
    }

    /**
     * 写数据
     * void write(int c) 写单个字符。
     * void write(char[] ch) 写字符数组。
     * void write(char[] ch,int off,int len) 写字符数组⼀部分，开始索引和写出
     * 的个数。
     * void write(String s) 写⼊字符串。
     *
     * @throws IOException
     */
    public static void transferDemo() throws IOException {
        //    定义文件路径
        String filename = "D:\\test.txt";
        //    创建流对象，默认UTF-8编码
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filename));
        //    写数据，保存为6个字节
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();

        //    定义文件路径
        String filename2 = "D:\\test1.txt";
        //    创建流对象，指定GBK编码
        OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(new FileOutputStream(filename2), "GBK");
        //    写数据，保存为4字节
        outputStreamWriter1.write("你好");
        outputStreamWriter1.flush();
        outputStreamWriter1.close();
    }

    /**
     * 读取数据⽅法
     * int read() 读取单个字符，读取到⽂件末尾时返回-1。
     * int read(char[] ch) 读取字符存储到数组中个，返回读取到的字符个数，读取到⽂
     * 件末尾时返回-1。
     *
     * @throws IOException
     */
    public static void transferReader() throws IOException {
        //    定义需要读取的文件路径
        String fileName = "D:\\dev\\Java\\java-basic\\test.txt";
        //    创建流对象，默认UTF8编码
        InputStream in;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
        //    创建流对象指定GBK编码
        InputStreamReader inputStreamReader1 = new InputStreamReader(new FileInputStream(fileName), "GBK");
        //    定义变量，保存字符
        int read;
        System.out.println("\n********************使用GBK编码读取*********************\n");
        //使用默认编码字符流读取
        while ((read = inputStreamReader.read()) != -1) {
            System.out.print((char) read);
        }
        inputStreamReader.close();
        System.out.println("\n**********************\n");
        // 使⽤指定编码字符流读取,正常解析
        while ((read = inputStreamReader1.read()) != -1) {
            System.out.print((char) read);
        }
        inputStreamReader1.close();

    }

    /**
     * 写数据
     * FileWriter(File file) ： 创建⼀个新的 FileWriter，给定要读取的File对象。
     * FileWriter(String fileName) ： 创建⼀个新的 FileWriter，给定要读取的⽂件的
     * 名称。
     *
     * @throws IOException
     */
    public static void fileWriterDemo() throws IOException {
        //    使用文件名称创建流对象
        FileWriter fileWriter = new FileWriter("file.txt");
        //    写出单个字符
        fileWriter.write(97);
        fileWriter.flush();
        //    写出字符数组
        char[] chars = "ABCDEF".toCharArray();
        fileWriter.write(chars);
        fileWriter.flush();

        //    写出字符数组的一部分,开始索引，写出个数
        fileWriter.write(chars, 1, 3);
        fileWriter.flush();
        //    写出字符串
        fileWriter.write("Java工程师");
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * FileReader 读取文件
     * FileWriter(File file) ： 创建⼀个新的 FileWriter，给定要读取的File对象。
     * FileWriter(String fileName) ： 创建⼀个新的 FileWriter，给定要读取的⽂件的
     * 名称。
     *
     * @throws IOException
     */
    public static void fileReaderDemo() throws IOException {
        // 使⽤⽂件名称创建流对象，读取的源⽂件read.txt在项⽬根⽬录下
        FileReader fr = new FileReader("read.txt");
        // 定义变量，保存有效字符个数
        int len;
        // 定义字符数组，作为装字符数据的容器
        char[] buf = new char[2];
        // 循环读取
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        // 关闭资源
        fr.close();
    }

    /**
     * 字符缓冲流
     *
     * @throws IOException
     */
    public static void bufferWriterDemo() throws IOException {
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
        // 写出数据
        bw.write("Java");
        // 写出换⾏
        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");
        bw.newLine();
        // 释放资源
        bw.close();
    }

    /**
     * readLine()读取⽂本⾏
     *
     * @throws IOException
     */
    public static void bufferReaderDemo() throws IOException {
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("read.txt"));
        // 定义字符串,保存读取的⼀⾏⽂字
        String line = null;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine()) != null) {
            System.out.print(line);
            System.out.println("------");
        }
        // 释放资源
        br.close();
    }

    public static void txtSort() throws IOException {
        //    创建ArrayList集合,泛型使用String
        ArrayList<String> list = new ArrayList<>();
        //    创建BufferedReader对象,构造方法中传递FileReader对象
        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
        //    创建BufferWriter对象,构造方法传递FileWriter对象
        Writer out;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        //    使用BufferedReader对象中的方法readLine,以行的方式读取文本
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //    把读取的文本存储到ArrayList集合中
            list.add(line);
        }
        //    使用Collections集合工具类中的方法sort,对集合中的元素按照自定义规则排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
            }
        });
        //    遍历ArrayList集合,获取每一个元素
        for (String s : list) {
            //    使用BufferedWriter对象中的方法write,遍历得到的元素写入到文本中(内容缓冲区中)
            bufferedWriter.write(s);
            //    换行写
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        //    释放资源
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void printWriterDemo() throws IOException {
        // 创建打印流,输出⽬的是字节输出流
        //PrintWriter pw1 = new PrintWriter(new FileOutputStream("a.txt"),true);
        //创建打印流,输出⽬的是字符
        PrintWriter pw = new PrintWriter(new FileWriter("a.txt"), true);
        pw.println(97);
        pw.println(98);
        pw.close();
    }

    public static void writeObjectDemo() {
        Employee e = new Employee();
        e.name = "zhangsan";
        e.address = "jiangsu";
        e.age=20;
        try {
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new
                    FileOutputStream("employee.txt"));
            // 写出对象
            out.writeObject(e);
            // 释放资源
            out.close();
            System.out.println("Serialized data is saved");
            // 姓名，地址被序列化，年龄没有被序列化。
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static void readObjectDemo() {
        Employee e;
        try {
            // 创建反序列化流
            FileInputStream fileIn = new FileInputStream("employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 读取⼀个对象
            e = (Employee) in.readObject();
            // 释放资源
            in.close();
            fileIn.close();
        } catch (IOException i) {
            // 捕获其他异常
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            // 捕获类找不到异常
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        // ⽆异常,直接打印输出
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("age: " + e.age);
    }
}