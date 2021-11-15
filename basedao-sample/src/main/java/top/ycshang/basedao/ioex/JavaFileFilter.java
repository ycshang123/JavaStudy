package top.ycshang.basedao.ioex;

import java.io.File;
import java.util.Objects;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-15 20:00
 **/
public class JavaFileFilter {
    public static void main(String[] args) {
        File dir = new File("D:\\dev\\JavaStudy\\basedao-sample\\src\\main\\java\\top\\ycshang\\basedao");
        File[] files = dir.listFiles(file -> {
            //判断如果获取到的是⽬录，直接放⾏
            if (file.isDirectory()) {
                return true;
            }
            //获取路径中的⽂件名，判断是否java结尾，是就返回true
            return file.getName().toLowerCase().endsWith("java");
        });
        //遍历files数组
        for (File file : Objects.requireNonNull(files)) {
            System.out.println(file);
        }
    }
}