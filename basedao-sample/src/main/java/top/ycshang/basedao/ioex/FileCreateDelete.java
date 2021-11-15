package top.ycshang.basedao.ioex;

import java.io.File;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description: File的创建和删除⽅法
 * @author: ycshang
 * @create: 2021-11-15 19:36
 **/
public class FileCreateDelete {
    public static void main(String[] args) throws IOException {
        // ⽂件的创建
        File f = new File("test.txt");
        System.out.println("是否存在:" + f.exists());
        System.out.println("是否创建:" + f.createNewFile());
        System.out.println("是否存在:" + f.exists());
        // ⽬录的创建
        File f2 = new File("java-basic");
        System.out.println("是否存在:" + f2.exists());
        System.out.println("是否创建:" + f2.mkdirs());
        System.out.println("是否存在:" + f2.exists());
        // ⽂件的删除
        System.out.println(f.delete());
        // ⽬录的删除
        System.out.println(f2.delete());
    }
}