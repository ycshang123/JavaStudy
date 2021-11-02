package top.ycshang.netty.demo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.StandardCharsets;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-01 19:27
 **/
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

    private EventLoopGroup group = new NioEventLoopGroup();

    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 解码转String，注意调整自己的编码格式
        pipeline.addLast("stringDecoder", new StringDecoder(StandardCharsets.UTF_8));
        pipeline.addLast(group, new MyServerHandler());
    }

}