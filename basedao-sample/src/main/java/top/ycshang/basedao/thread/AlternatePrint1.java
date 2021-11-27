package top.ycshang.basedao.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-28 00:17
 **/
public class AlternatePrint1 {
    private static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (int i = 0; i < aC.length; i++) {
                // 起始先打印一个字母
                System.out.print(aC[i]);
                // 打印完唤醒t2打印数字
                LockSupport.unpark(t2);
                // 自己阻塞，等待唤醒
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < aI.length; i++) {
                // 起始先阻塞等待
                LockSupport.park();
                // 被唤醒后打印数字
                System.out.print(aI[i]);
                // 唤醒t1
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }

}