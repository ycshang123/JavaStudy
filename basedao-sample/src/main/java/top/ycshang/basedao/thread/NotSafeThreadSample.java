package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 23:49
 **/
public class NotSafeThreadSample {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // t1线程对变量+1000次
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        // t2线程对变量-1000次
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count--;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
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