package top.ycshang.chat.client.socket.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import top.ycshang.chat.client.application.UIService;
import top.ycshang.chat.protocol.msg.MsgGroupResponse;
import top.ycshang.chatui.view.chat.IChatMethod;

/**
 * @author ycshang
 */
public class MsgGroupHandler extends SimpleChannelInboundHandler<MsgGroupResponse> {

    private final UIService uiService;

    public MsgGroupHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgGroupResponse msg) throws Exception {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addTalkMsgGroupLeft(msg.getTalkId(), msg.getUserId(), msg.getUserNickName(), msg.getUserHead(), msg.getMsg(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
        });
    }

}
