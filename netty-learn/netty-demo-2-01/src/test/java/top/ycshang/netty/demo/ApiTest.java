package top.ycshang.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-02 19:28
 **/
public class ApiTest {
    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                    channel.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
                    channel.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
                    channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 客户端接收到消息：" + msg);
                        }
                    });
                }
            });
            ChannelFuture f = b.connect("127.0.0.1", 7397).sync();
            System.out.println("Netty客户端启动成功！");

            f.channel().writeAndFlush("你好，SpringBoot启动的Netty服务端，我是mqxu,这条消息结尾是一个换行符，用于传输半包粘包处理”\r\n");
            f.channel().writeAndFlush("你好，SpringBoot启动的Netty服务端，我是mqxu,这条消息结尾是一个换行符，用于传输半包粘包处理”\r\n");
            f.channel().writeAndFlush("你好，SpringBoot启动的Netty服务端，我是mqxu,这条消息结尾是一个换行符，用于传输半包粘包处理”\r\n");
            f.channel().writeAndFlush("你好，SpringBoot启动的Netty服务端，我是mqxu,这条消息结尾是一个换行符，用于传输半包粘包处理”\r\n");
            f.channel().writeAndFlush("你好，SpringBoot启动的Netty服务端，我是mqxu,这条消息结尾是一个换行符，用于传输半包粘包处理”\r\n");

            f.channel().closeFuture().syncUninterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}