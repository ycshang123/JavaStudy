package top.ycshang.chat.client.socket.handler;


import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import lombok.extern.slf4j.Slf4j;
import top.ycshang.chat.client.application.UIService;
import top.ycshang.chat.protocol.login.LoginResponse;
import top.ycshang.chat.protocol.login.dto.ChatRecordDto;
import top.ycshang.chat.protocol.login.dto.ChatTalkDto;
import top.ycshang.chat.protocol.login.dto.GroupsDto;
import top.ycshang.chat.protocol.login.dto.UserFriendDto;
import top.ycshang.chatui.view.chat.IChatMethod;

import java.util.List;

/**
 * 登录业务流程处理
 *
 * @author ycshang
 */
@Slf4j
public class LoginHandler extends SimpleChannelInboundHandler<LoginResponse> {

    private final UIService uiService;

    public LoginHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponse msg) throws Exception {
        log.info("消息处理中 ...");
        log.info("消息内容：${}", msg);
        if (!msg.isSuccess()) {
            log.error("登陆失败");
            return;
        }
        Platform.runLater(() -> {
            uiService.getLogin().doLoginSuccess();
            IChatMethod chat = uiService.getChat();
            // 设置用户信息
            chat.setUserInfo(msg.getUserId(), msg.getUserNickName(), msg.getUserHead());
            // 对话框
            List<ChatTalkDto> chatTalkList = msg.getChatTalkList();
            if (null != chatTalkList) {
                chatTalkList.forEach(talk -> {
                            chat.addTalkBox(0, talk.getTalkType(), talk.getTalkId(), talk.getTalkName(), talk.getTalkHead(), talk.getTalkSketch(), talk.getTalkDate(), true);
                            switch (talk.getTalkType()) {
                                // 好友
                                case 0:
                                    List<ChatRecordDto> userRecordList = talk.getChatRecordList();
                                    if (null == userRecordList || userRecordList.isEmpty()) {
                                        return;
                                    }
                                    for (int i = userRecordList.size() - 1; i >= 0; i--) {
                                        ChatRecordDto chatRecord = userRecordList.get(i);
                                        //  自己的消息
                                        if (0 == chatRecord.getMsgType()) {
                                            chat.addTalkMsgRight(chatRecord.getTalkId(), chatRecord.getMsgContent(), chatRecord.getMsgType(), chatRecord.getMsgDate(), true, false, false);
                                            continue;
                                        }
                                        // 好友的消息
                                        if (1 == chatRecord.getMsgType()) {
                                            chat.addTalkMsgUserLeft(chatRecord.getTalkId(), chatRecord.getMsgContent(), chatRecord.getMsgType(), chatRecord.getMsgDate(), true, false, false);
                                        }
                                    }
                                    break;
                                // 群组
                                case 1:
                                    List<ChatRecordDto> groupRecordList = talk.getChatRecordList();
                                    if (null == groupRecordList || groupRecordList.isEmpty()) {
                                        return;
                                    }
                                    for (int i = groupRecordList.size() - 1; i >= 0; i--) {
                                        ChatRecordDto chatRecord = groupRecordList.get(i);
                                        //  自己的消息
                                        if (0 == chatRecord.getMsgUserType()) {
                                            chat.addTalkMsgRight(chatRecord.getTalkId(), chatRecord.getMsgContent(), chatRecord.getMsgType(), chatRecord.getMsgDate(), true, false, false);
                                            continue;
                                        }
                                        // 他人的消息
                                        if (1 == chatRecord.getMsgUserType()) {
                                            chat.addTalkMsgGroupLeft(chatRecord.getTalkId(), chatRecord.getUserId(), chatRecord.getUserNickName(), chatRecord.getUserHead(), chatRecord.getMsgContent(), chatRecord.getMsgType(), chatRecord.getMsgDate(), true, false, false);
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }

                        }
                );

            }
            // 群组
            List<GroupsDto> groupsList = msg.getGroupsList();
            if (null != groupsList) {
                groupsList.forEach(groups -> chat.addFriendGroup(groups.getGroupId(), groups.getGroupName(), groups.getGroupHead()));
            }
            // 好友
            List<UserFriendDto> userFriendList = msg.getUserFriendList();
            if (null != userFriendList) {
                userFriendList.forEach(friend -> chat.addFriendUser(false, friend.getFriendId(), friend.getFriendName(), friend.getFriendHead()));
            }
        });
    }

}
