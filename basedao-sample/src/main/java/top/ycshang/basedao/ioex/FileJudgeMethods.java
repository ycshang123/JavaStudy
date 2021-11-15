package top.ycshang.basedao.ioex;

import java.io.File;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-15 19:31
 **/
public class FileJudgeMethods {
    public static void main(String[] args) {
        File f = new File("D:\\dev\\Java\\java-basic\\test.txt");
        File f2 = new File("D:\\dev\\Java\\java-basic");
        // 判断是否存在
        System.out.println("D:\\dev\\Java\\java-basic 是否存在:" +
                f.exists());
        System.out.println("D:\\dev\\Java\\java-basic\\test.txt 是否存在" + f2.exists());
        // 判断是⽂件还是⽬录
        System.out.println("D:\\dev\\Java\\java-basic是⽂件?:" +
                f2.isFile());
        System.out.println("D:\\dev\\Java\\java-basic是⽬录?:" +
                f2.isDirectory());
    }
}