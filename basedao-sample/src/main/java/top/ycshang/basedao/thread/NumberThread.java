package top.ycshang.basedao.thread;

import javax.swing.*;
import java.util.Random;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 23:58
 **/
public class NumberThread implements Runnable{
    private final JLabel numberLabel;

    public NumberThread(JLabel numberLabel) {
        this.numberLabel = numberLabel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            numberLabel.setText(String.valueOf(random.nextInt(100)));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}