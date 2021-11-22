package top.ycshang.basedao.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 20:05
 **/
public class MyThread extends Thread {
    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("Running:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Running:" + Thread.currentThread().getName());
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(df.format(new Date()));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + "exited");
    }
}