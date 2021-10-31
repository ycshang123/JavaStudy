package top.ycshang.demo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-10-31 18:54
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketHandler) throws Exception {
        System.out.println("连接报告开始");
        System.out.println("连接报告信息：有一客户端链接到本服务端");
        System.out.println("连接IP:" + socketHandler.localAddress().getHostString());
        System.out.println("连接Port:" + socketHandler.localAddress().getPort());
        System.out.println("连接报告完毕");

    }
}