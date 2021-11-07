package top.ycshang.chat.client.socket.handler;

import io.netty.channel.Channel;
import javafx.application.Platform;
import top.ycshang.chat.client.application.UIService;
import top.ycshang.chat.client.socket.MyBizHandler;
import top.ycshang.chat.protocol.friend.AddFriendResponse;
import top.ycshang.chatui.view.chat.IChatMethod;

/**
 * @author ycshang
 */
public class AddFriendHandler extends MyBizHandler<AddFriendResponse> {

    public AddFriendHandler(UIService uiService) {
        super(uiService);
    }

    @Override
    public void channelRead(Channel channel, AddFriendResponse msg) {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> chat.addFriendUser(true, msg.getFriendId(), msg.getFriendNickName(), msg.getFriendHead()));
    }

}
