package top.ycshang.basedao.ioex;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: basedao-sample
 * @description: 使⽤循环改进字节读取
 * @author: ycshang
 * @create: 2021-11-16 00:19
 **/
public class ReadByLoop {
    public static void main(String[] args) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileInputStream fis = new FileInputStream("read.txt");
        // 定义变量，保存数据
        int b = 0;
        // 循环读取
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        // 关闭资源
        fis.close();
    }
}