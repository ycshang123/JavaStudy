package top.ycshang.netty.demo.server.server.aio.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

/**
 * @program: netty-demo-1-00
 * @description:
 * @author: ycshang
 * @create: 2021-10-30 19:33
 **/
public class AioClient {
    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        Future<Void> future = socketChannel.connect(new InetSocketAddress("10.30.134.84", 7397));
        System.out.println("AIO客户端启动成功！");
        future.get();
        socketChannel.read(ByteBuffer.allocate(1024), null, new AioClientHandler(socketChannel, StandardCharsets.UTF_8));
        Thread.sleep(30000);
    }
}