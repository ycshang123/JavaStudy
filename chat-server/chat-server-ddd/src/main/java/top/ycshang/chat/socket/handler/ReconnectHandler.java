package top.ycshang.chat.socket.handler;

import io.netty.channel.Channel;
import top.ycshang.chat.application.UserService;
import top.ycshang.chat.infrastructure.common.SocketChannelUtil;
import top.ycshang.chat.protocol.login.ReconnectRequest;
import top.ycshang.chat.socket.MyBizHandler;


import java.util.List;

/**
 * 重连处理
 * @author ycshang
 */
public class ReconnectHandler extends MyBizHandler<ReconnectRequest> {

    public ReconnectHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, ReconnectRequest msg) {
        logger.info("客户端断线重连处理。userId：{}", msg.getUserId());
        // 添加用户Channel
        SocketChannelUtil.removeUserChannelByUserId(msg.getUserId());
        SocketChannelUtil.addChannel(msg.getUserId(), channel);
        // 添加群组Channel
        List<String> groupsIdList = userService.queryTalkBoxGroupsIdList(msg.getUserId());
        for (String groupsId : groupsIdList) {
            SocketChannelUtil.addChannelGroup(groupsId, channel);
        }
    }

}
