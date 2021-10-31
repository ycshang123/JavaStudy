package top.ycshang.netty.demo.server.server.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-10-31 19:12
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("连接报告开始");
        System.out.println("连接报告信息：有一客户端链接到本服务端");
        System.out.println("连接IP:" + socketChannel.localAddress().getHostString());
        System.out.println("连接Port:" + socketChannel.localAddress().getPort());
        System.out.println("连接报告完毕");
        //在管道中添加我们自己的接收数据实现方法
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
