package top.ycshang.chat.socket.handler;

import io.netty.channel.Channel;
import top.ycshang.chat.application.UserService;
import top.ycshang.chat.protocol.talk.DelTalkRequest;
import top.ycshang.chat.socket.MyBizHandler;

/**
 * @author ycshang
 */
public class DelTalkHandler extends MyBizHandler<DelTalkRequest> {

    public DelTalkHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, DelTalkRequest msg) {
        userService.deleteUserTalk(msg.getUserId(), msg.getTalkId());
    }
}
