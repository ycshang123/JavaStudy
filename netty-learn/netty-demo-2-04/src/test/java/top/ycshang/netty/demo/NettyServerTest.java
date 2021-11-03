package top.ycshang.netty.demo;

import top.ycshang.netty.demo.server.NettyServer;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-03 21:52
 **/
public class NettyServerTest {

    public static void main(String[] args) {
        System.out.println("学习之路，学无止境");
        new NettyServer().bing(7397);
    }
}