package top.ycshang.basedao.ioex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 00:17
 **/
public class FileInputStreamConstructor {
    public static void main(String[] args) throws IOException {
        // 使⽤File对象创建流对象,⽂件如不存在会报异常
        File file = new File("read.txt");
        FileInputStream fos = new FileInputStream(file);
        // 使⽤⽂件名称创建流对象
        FileInputStream fos1 = new FileInputStream("read.txt");
    }

}