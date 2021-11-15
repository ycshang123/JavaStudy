package top.ycshang.basedao.ioex;

import java.io.File;

/**
 * @program: basedao-sample
 * @description: 绝对路径和相对路径
 * @author: ycshang
 * @create: 2021-11-15 19:28
 **/
public class FilePath {
    public static void main(String[] args) {
        File f = new File("D:\\dev\\Java\\java-basic\\test.txt");
        System.out.println(f.getAbsolutePath());
        File f2 = new File("SeparatorDemo.java");
        System.out.println(f2.getAbsolutePath());
    }
}