package top.ycshang.chat.client.event;

import io.netty.channel.Channel;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;
import top.ycshang.chat.client.infrastructure.util.BeanUtil;
import top.ycshang.chat.protocol.friend.AddFriendRequest;
import top.ycshang.chat.protocol.friend.SearchFriendRequest;
import top.ycshang.chat.protocol.msg.MsgGroupRequest;
import top.ycshang.chat.protocol.msg.MsgRequest;
import top.ycshang.chat.protocol.talk.DelTalkRequest;
import top.ycshang.chat.protocol.talk.TalkNoticeRequest;
import top.ycshang.chatui.view.chat.IChatEvent;

import java.util.Date;

/**
 * @author ycshang
 */
@Slf4j
public class ChatEvent implements IChatEvent {


    @Override
    public void doQuit() {
        log.info("退出登陆！");
        BeanUtil.getBean("channel", Channel.class).close();
    }

    @Override
    public void doSendMsg(String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        // 好友0
        if (0 == talkType) {
            channel.writeAndFlush(new MsgRequest(userId, talkId, msg, msgType, msgDate));
        }
        // 群组1
        else if (1 == talkType) {
            channel.writeAndFlush(new MsgGroupRequest(talkId, userId, msg, msgType, msgDate));
        }
    }


    @Override
    public void doEventAddTalkUser(String userId, String userFriendId) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new TalkNoticeRequest(userId, userFriendId, 0));
    }

    @Override
    public void doEventAddTalkGroup(String userId, String groupId) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new TalkNoticeRequest(userId, groupId, 1));
    }

    @Override
    public void doEventDelTalkUser(String userId, String talkId) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new DelTalkRequest(userId, talkId));
    }

    @Override
    public void addFriendNew(String userId, ListView<Pane> listView) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new SearchFriendRequest(userId, ""));
    }

    @Override
    public void doFriendNewSearch(String userId, String text) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new SearchFriendRequest(userId, text));
    }

    @Override
    public void doEventAddNewUser(String userId, String friendId) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new AddFriendRequest(userId, friendId));
    }
}
