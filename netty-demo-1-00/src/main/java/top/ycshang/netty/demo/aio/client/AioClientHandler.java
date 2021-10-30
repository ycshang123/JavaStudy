package top.ycshang.netty.demo.aio.client;

import top.ycshang.netty.demo.aio.ChannelAdapter;
import top.ycshang.netty.demo.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @program: netty-demo-1-00
 * @description: 客户端消息处理器
 * @author: ycshang
 * @create: 2021-10-30 19:33
 **/
public class AioClientHandler extends ChannelAdapter {

    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            //通知客户端连接建立成功
            System.out.println("客户端连接成功:" + ctx.channel().getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelInactive(ChannelHandler ctx) {
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("\r\n客户端信息处理成功！\r\n");
    }

}