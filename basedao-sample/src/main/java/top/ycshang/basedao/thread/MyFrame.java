package top.ycshang.basedao.thread;

import javax.swing.*;
import java.awt.*;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-23 00:06
 **/
public class MyFrame extends JFrame {
    private final JLabel timeLabel;
    private final JLabel numberLabel;
    private final JLabel imgLabel;

    public MyFrame() {
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        numberLabel = new JLabel();
        numberLabel.setFont(font);
        imgLabel = new JLabel();
        TimeThread tt = new TimeThread(timeLabel);
        NumberThread nt = new NumberThread(numberLabel);
        ImageThread it = new ImageThread(imgLabel);
        new Thread(tt).start();
        new Thread(nt).start();
        new Thread(it).start();
        this.add(timeLabel, BorderLayout.NORTH);
        this.add(numberLabel, BorderLayout.SOUTH);
        this.add(imgLabel);
        this.setTitle("各种线程在一起的窗体");
        this.setSize(800, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}