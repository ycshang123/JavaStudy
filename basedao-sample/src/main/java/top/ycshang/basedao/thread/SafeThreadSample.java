package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 23:56
 **/
public class SafeThreadSample {
    private static int count = 0;

    private static Object lock = new Object();

    private static Object lock2 = new Object();

    /**
     * t1线程和t2对象都是对同一对象加锁。保证了线程安全。此段代码无论执行多少次，结果都是0
     *
     * @param args 入参数组
     * @throws InterruptedException 中断异常
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        });

        t1.start();
        t2.start();
        // 让t1 t2都执行完
        t1.join();
        t2.join();
        System.out.println(count);
    }

}