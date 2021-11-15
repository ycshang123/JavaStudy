package top.ycshang.basedao.ioex;

import java.io.File;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-15 19:14
 **/
public class FileConstructor {
    public static void main(String[] args) {
        //   文件路径名
        String pathname = "D:\\dev\\Java\\java-basic\\test.txt";
        File file = new File(pathname);
        System.out.println(file);
        //    通过父路径和子路径字符串
        String parent = "D:\\dev\\Java\\java-basic";
        String child1 = "test.txt";
        File file1 = new File(parent, child1);
        System.out.println(file1);
        //    通过父级File对象和子路径字符串
        File parentDir = new File("D:\\dev\\Java\\java-basic");
        String child2 = "test.txt";
        File file2 = new File(parentDir, child2);
        System.out.println(file2);
    }
}