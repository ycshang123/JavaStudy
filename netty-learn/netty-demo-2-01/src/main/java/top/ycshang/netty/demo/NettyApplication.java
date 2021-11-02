package top.ycshang.netty.demo;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.ycshang.netty.demo.server.NettyServer;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-02 19:22
 **/
@SpringBootApplication
@ComponentScan("top.ycshang.netty.demo")
public class NettyApplication implements CommandLineRunner {

    @Value("${netty.host}")
    private String host;

    @Value("${netty.port}")
    private int port;

    @Resource
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(host, port);
        ChannelFuture channelFuture = nettyServer.bing(address);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
        channelFuture.channel().closeFuture().syncUninterruptibly();
    }
}
