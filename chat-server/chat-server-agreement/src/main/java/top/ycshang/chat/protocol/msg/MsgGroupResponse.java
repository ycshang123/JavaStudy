package top.ycshang.chat.protocol.msg;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ycshang.chat.protocol.Command;
import top.ycshang.chat.protocol.Packet;

import java.util.Date;

/**
 * 群组消息响应
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class MsgGroupResponse extends Packet {
    /**
     * 对话框ID
     */
    private String talkId;
    /**
     * 群员用户ID
     */
    private String userId;
    /**
     * 群员用户昵称
     */
    private String userNickName;
    /**
     * 群员用户头像
     */
    private String userHead;
    /**
     * 群员用户发送消息内容
     */
    private String msg;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    /**
     * 群员用户发送消息时间
     */
    private Date msgDate;

    public MsgGroupResponse() {
    }


    @Override
    public Byte getCommand() {
        return Command.MsgGroupResponse;
    }
}
