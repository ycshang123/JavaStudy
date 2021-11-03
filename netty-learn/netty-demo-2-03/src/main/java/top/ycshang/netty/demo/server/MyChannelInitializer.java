package top.ycshang.netty.demo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import top.ycshang.netty.demo.codec.ObjDecoder;
import top.ycshang.netty.demo.codec.ObjEncoder;
import top.ycshang.netty.demo.domain.MsgInfo;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-03 21:21
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }

}