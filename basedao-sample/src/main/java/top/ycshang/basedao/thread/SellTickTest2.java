package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 23:46
 **/
public class SellTickTest2 {
    public static void main(String[] args) {
        TicketWindow2 tw = new TicketWindow2();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(tw, "窗口" + i);
            t.start();
        }
    }
}

class TicketWindow2 implements Runnable {
    private int ticket = 30;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了一张票,当前票是为:" + --ticket);

            } else {
                System.out.println(Thread.currentThread().getName() + "余票不足,无法售票！");
                break;
            }
        }
    }
}