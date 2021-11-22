package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description: 线程状态——BLOCKED
 * @author: ycshang
 * @create: 2021-11-22 20:37
 **/
public class ThreadStateBlockExample {
    private static final boolean LOCK_FLAG = true;

    public static void main(String[] args) {
        Runnable locker = ThreadStateBlockExample::locker;
        /**
         *启动whoWillLockOthers线程，主线程休眠1秒让子线程先运行
         * 此时whoWillLockOthers获得锁，这时候其他线程需要等待
         */
        Thread whoWillLockOthers = new Thread(locker);
        whoWillLockOthers.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread whoWillBeLocked = new Thread(locker);
        /**
         * 启动whoWillBeLocked线程，主线程休眠1秒让子线程先运行
         * 因为locker方法是个死循环，所以whoWillBeLocked线程永远拿不到锁，就会进入BLOCKED状态
         */
        whoWillBeLocked.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whoWillBeLocked线程的当前状态为=" + whoWillBeLocked.getState() + "");
        System.exit(1);

    }

    private static synchronized void locker() {
        do {
        } while (LOCK_FLAG);
    }
}