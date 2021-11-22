package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 23:35
 **/
public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("1号竞猜机器启动");
        Thread thread1 = new GuessNumber(27);
        thread1.setName("1号精彩机器");
        thread1.start();

        System.out.println("2号竞猜机器启动");
        Thread thread2 = new GuessNumber(72);
        thread2.setName("2号竞猜机器");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }
}