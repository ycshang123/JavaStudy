package top.ycshang.basedao.thread;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-23 00:00
 **/
public class ImageThread implements Runnable {
    private JLabel imageLabel;
    private static List<String> imageList = new ArrayList<>(
            Arrays.asList("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg",
                    "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/dark-wel.3rqe2eio7760.jpg",
                    "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.22asgtnxynvk.jpg",
                    "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag3.1ao7erlnhbcw.jpg",
                    "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg")
    );

    public ImageThread(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    @Override
    public void run() {
        for(int i=0;i<imageList.size();i++){
            Icon icon = null;
            try {
                icon = new ImageIcon(new URL(imageList.get(i)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            imageLabel.setIcon(icon);
            imageLabel.repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}