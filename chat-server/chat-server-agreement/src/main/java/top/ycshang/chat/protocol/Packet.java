package top.ycshang.chat.protocol;

import top.ycshang.chat.protocol.friend.AddFriendRequest;
import top.ycshang.chat.protocol.friend.AddFriendResponse;
import top.ycshang.chat.protocol.friend.SearchFriendRequest;
import top.ycshang.chat.protocol.friend.SearchFriendResponse;
import top.ycshang.chat.protocol.login.LoginRequest;
import top.ycshang.chat.protocol.login.LoginResponse;
import top.ycshang.chat.protocol.login.ReconnectRequest;
import top.ycshang.chat.protocol.msg.MsgGroupRequest;
import top.ycshang.chat.protocol.msg.MsgGroupResponse;
import top.ycshang.chat.protocol.msg.MsgRequest;
import top.ycshang.chat.protocol.msg.MsgResponse;
import top.ycshang.chat.protocol.talk.DelTalkRequest;
import top.ycshang.chat.protocol.talk.TalkNoticeRequest;
import top.ycshang.chat.protocol.talk.TalkNoticeResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 协议包
 *
 * @author ycshang
 */
public abstract class Packet {

    private final static Map<Byte, Class<? extends Packet>> PACK_TYPE = new ConcurrentHashMap<>();

    static {
        PACK_TYPE.put(Command.LoginRequest, LoginRequest.class);
        PACK_TYPE.put(Command.LoginResponse, LoginResponse.class);
        PACK_TYPE.put(Command.MsgRequest, MsgRequest.class);
        PACK_TYPE.put(Command.MsgResponse, MsgResponse.class);
        PACK_TYPE.put(Command.TalkNoticeRequest, TalkNoticeRequest.class);
        PACK_TYPE.put(Command.TalkNoticeResponse, TalkNoticeResponse.class);
        PACK_TYPE.put(Command.SearchFriendRequest, SearchFriendRequest.class);
        PACK_TYPE.put(Command.SearchFriendResponse, SearchFriendResponse.class);
        PACK_TYPE.put(Command.AddFriendRequest, AddFriendRequest.class);
        PACK_TYPE.put(Command.AddFriendResponse, AddFriendResponse.class);
        PACK_TYPE.put(Command.DelTalkRequest, DelTalkRequest.class);
        PACK_TYPE.put(Command.MsgGroupRequest, MsgGroupRequest.class);
        PACK_TYPE.put(Command.MsgGroupResponse, MsgGroupResponse.class);
        PACK_TYPE.put(Command.ReconnectRequest, ReconnectRequest.class);
    }

    public static Class<? extends Packet> get(Byte command) {
        return PACK_TYPE.get(command);
    }

    /**
     * 获取协议指令
     *
     * @return 返回指令值
     */
    public abstract Byte getCommand();

}
