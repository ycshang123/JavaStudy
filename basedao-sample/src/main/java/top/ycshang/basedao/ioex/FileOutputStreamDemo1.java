package top.ycshang.basedao.ioex;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 00:12
 **/
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 写出数据
        // 写出第1个字节
        fos.write(97);
        // 写出第2个字节
        fos.write(98);
        // 写出第3个字节
        fos.write(99);
        // 关闭资源
        fos.close();
    }
}