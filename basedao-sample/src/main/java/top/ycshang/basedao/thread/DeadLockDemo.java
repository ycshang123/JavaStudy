package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-27 00:08
 **/
public class DeadLockDemo {
    static Beer beer = new Beer();
    static Story story = new Story();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (beer) {
                System.out.println("我有酒，给我故事");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                synchronized (story) {
                    System.out.println("小王开始喝酒讲故事");
                }
            }
        }, "小王").start();

        new Thread(() -> {
            synchronized (story) {
                System.out.println("我有故事，给我酒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                synchronized (beer) {
                    System.out.println("老王开始喝酒讲故事");
                }
            }
        }, "老王").start();
    }
}