package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-28 00:16
 **/
public class ThreadLocalTest2 {
    /**
     * 创建ThreadLocal变量
     */
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        threadLocal.set("mainVal");
        //新创建一个子线程
        Thread thread = new Thread(() -> System.out.println("子线程中的本地变量值:" + threadLocal.get()));
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("main线程中的本地变量值:" + threadLocal.get());
    }
}