package top.ycshang.netty.demo.util;

import top.ycshang.netty.demo.domain.MsgInfo;

/**
 * @program: netty-learn
 * @description:
 * @author: ycshang
 * @create: 2021-11-03 21:22
 **/
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }

}