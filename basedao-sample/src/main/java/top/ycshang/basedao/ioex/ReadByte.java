package top.ycshang.basedao.ioex;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 00:18
 **/
public class ReadByte {
    public static void main(String[] args) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileInputStream fis = new FileInputStream("read.txt");
        // 读取数据，返回⼀个字节
        int read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        // 读取到末尾,返回-1
        read = fis.read();
        System.out.println(read);
        // 关闭资源
        fis.close();
    }
}