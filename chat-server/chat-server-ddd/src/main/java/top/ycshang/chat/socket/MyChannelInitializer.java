package top.ycshang.chat.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import top.ycshang.chat.application.UserService;
import top.ycshang.chat.codec.ObjDecoder;
import top.ycshang.chat.codec.ObjEncoder;
import top.ycshang.chat.socket.handler.*;

/**
 * @author ycshang
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final UserService userService;

    public MyChannelInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new AddFriendHandler(userService));
        channel.pipeline().addLast(new DelTalkHandler(userService));
        channel.pipeline().addLast(new LoginHandler(userService));
        channel.pipeline().addLast(new MsgGroupHandler(userService));
        channel.pipeline().addLast(new MsgHandler(userService));
        channel.pipeline().addLast(new ReconnectHandler(userService));
        channel.pipeline().addLast(new SearchFriendHandler(userService));
        channel.pipeline().addLast(new TalkNoticeHandler(userService));
        //对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }

}
