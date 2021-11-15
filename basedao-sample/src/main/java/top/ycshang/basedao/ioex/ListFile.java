package top.ycshang.basedao.ioex;

import java.io.File;
import java.util.Objects;

/**
 * @program: basedao-sample
 * @description: File类目录遍历方法
 * @author: ycshang
 * @create: 2021-11-15 19:58
 **/
public class ListFile {
    public static void main(String[] args) {
        File dir = new File("D:\\dev\\JavaStudy");
        //获取当前⽬录下的⽂件以及⽂件夹对象，通过⽂件对象可以获取更多信息
        File[] files = dir.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            System.out.println(file);
        }
    }
}