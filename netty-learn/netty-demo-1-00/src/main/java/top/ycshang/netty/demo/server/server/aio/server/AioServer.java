package top.ycshang.netty.demo.server.server.aio.server;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @program: netty-demo-1-00
 * @description: 服务端
 * @author: ycshang
 * @create: 2021-10-30 19:34
 **/
public class AioServer extends Thread {

    private AsynchronousServerSocketChannel serverSocketChannel;

    @Override
    public void run() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10));
            serverSocketChannel.bind(new InetSocketAddress(7397));
            System.out.println("AIO服务端启动成功！");
            // 等待
            CountDownLatch latch = new CountDownLatch(1);
            serverSocketChannel.accept(this, new AioServerChannelInitializer());
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AsynchronousServerSocketChannel serverSocketChannel() {
        return serverSocketChannel;
    }

    public static void main(String[] args) {
        new AioServer().start();
    }

}