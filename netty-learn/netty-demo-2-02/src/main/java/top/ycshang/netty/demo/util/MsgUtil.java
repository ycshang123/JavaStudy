package top.ycshang.netty.demo.util;

import top.ycshang.netty.demo.domain.MsgBody;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-02 19:52
 **/
public class MsgUtil {

    /**
     * 构建protobuf消息体
     */
    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }

}