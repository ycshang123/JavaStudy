package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 23:44
 **/
public class TwoPhaseTerminal {
    /**
     * 监控线程
     */
    private static Thread monitor;

    public static void main(String[] args) throws InterruptedException {
        start();
        Thread.sleep(5000);
        stop();
    }

    private static void start() {
        monitor = new Thread(() -> {
            // 不停的监控
            while (true) {
                Thread thread = Thread.currentThread();
                // 判断当前线程是否被打断
                if (thread.isInterrupted()) {
                    System.out.println("当前线程被打断,结束运行");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    // 监控逻辑中被打断后，打断标记为true
                    System.out.println("监控");
                } catch (InterruptedException e) {
                    // 休眠时被打断，抛出异常 。在该处捕获到， 此时打断标记还是false
                    // 再调用一次中断 使得中断标记为true
                    thread.interrupt();
                }
            }
        });
        monitor.start();
    }

    private static void stop() {
        monitor.interrupt();
    }
}