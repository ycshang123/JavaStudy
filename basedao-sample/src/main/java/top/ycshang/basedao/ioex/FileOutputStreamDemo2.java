package top.ycshang.basedao.ioex;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 00:14
 **/
public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 字符串转换为字节数组
        byte[] b = "abcdef".getBytes();
        // 写出字节数组数据
        fos.write(b);
        // 关闭资源
        fos.close();
    }
}