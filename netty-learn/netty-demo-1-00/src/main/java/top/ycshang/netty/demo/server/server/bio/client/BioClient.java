package top.ycshang.netty.demo.server.server.bio.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @program: netty-demo-1-00
 * @description:
 * @author: ycshang
 * @create: 2021-10-30 19:35
 **/
public class BioClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.30.134.84", 7397);
            System.out.println("BIO客户端启动成功！");
            BioClientHandler bioClientHandler = new BioClientHandler(socket, StandardCharsets.UTF_8);
            bioClientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}