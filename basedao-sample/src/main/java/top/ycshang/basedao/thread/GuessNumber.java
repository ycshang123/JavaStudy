package top.ycshang.basedao.thread;

import java.util.Random;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 23:31
 **/
public class GuessNumber extends Thread {
    private final int number;

    public GuessNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        int guess;
        Random random = new Random();
        do {
            guess = random.nextInt(100);
            System.out.println(this.getName() + "guess" + guess);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (guess != number);
        System.out.println(this.getName() + "猜对了!,猜了" + count + "次");
    }
}