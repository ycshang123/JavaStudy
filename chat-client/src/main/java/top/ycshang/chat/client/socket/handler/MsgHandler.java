package top.ycshang.chat.client.socket.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import top.ycshang.chat.client.application.UIService;
import top.ycshang.chat.protocol.msg.MsgResponse;
import top.ycshang.chatui.view.chat.IChatMethod;

/**
 * @author ycshang
 */
public class MsgHandler extends SimpleChannelInboundHandler<MsgResponse> {

    private final UIService uiService;

    public MsgHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgResponse msg) throws Exception {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addTalkMsgUserLeft(msg.getFriendId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
        });
    }

}

