package top.ycshang.chat.client.socket.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import top.ycshang.chat.client.application.UIService;
import top.ycshang.chat.protocol.friend.SearchFriendResponse;
import top.ycshang.chat.protocol.friend.dto.UserDto;
import top.ycshang.chatui.view.chat.IChatMethod;

import java.util.List;

/**
 * @author ycshang
 */
public class SearchFriendHandler extends SimpleChannelInboundHandler<SearchFriendResponse> {

    private final UIService uiService;

    public SearchFriendHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SearchFriendResponse msg) throws Exception {
        List<UserDto> list = msg.getList();
        if (null == list || list.isEmpty()) {
            return;
        }
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            for (UserDto user : list) {
                chat.addNewFriend(user.getUserId(), user.getUserNickName(), user.getUserHead(), user.getStatus());
            }
        });
    }

}
