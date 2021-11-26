package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 23:41
 **/
public class JoinDemo {
    private static int r;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            r = 10;
        });

        t.start();
        // 让主线程阻塞 等待t线程执行完才继续执行
        // 去除该行执行结果为0，加上该行执行结果为10
        t.join();
        System.out.println("r:" + r);
    }
}
