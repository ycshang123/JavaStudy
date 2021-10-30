package top.ycshang.netty.demo.nio.client;

import top.ycshang.netty.demo.nio.ChannelAdapter;
import top.ycshang.netty.demo.nio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: netty-demo-1-00
 * @description:
 * @author: ycshang
 * @create: 2021-10-30 19:36
 **/
public class NioClientHandler extends ChannelAdapter {
    public NioClientHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("LocalAddress:" + ctx.channel().getLocalAddress());
            ctx.writeAndFlush("我是NIO客户端的消息 \r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        ctx.writeAndFlush("\r\n hi 我已经收到你的消息！\r\n");
    }

}