package top.ycshang.netty.demo.server.server.aio.server;

import top.ycshang.netty.demo.server.server.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @program: netty-demo-1-00
 * @description:
 * @author: ycshang
 * @create: 2021-10-30 19:34
 **/
public class AioServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(AsynchronousSocketChannel channel) throws Exception {
        channel.read(ByteBuffer.allocate(1024), 10, TimeUnit.SECONDS, null, new AioServerHandler(channel, StandardCharsets.UTF_8));
    }
}