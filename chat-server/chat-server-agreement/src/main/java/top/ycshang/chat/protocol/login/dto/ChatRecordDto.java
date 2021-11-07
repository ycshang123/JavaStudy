package top.ycshang.chat.protocol.login.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 聊天记录Dto
 *
 * @author ycshang
 */
@Data
public class ChatRecordDto {

    private String talkId;
    private String userId;
    private String userNickName;
    private String userHead;
    /**
     * 消息类型[0自己/1好友]
     */
    private Integer msgUserType;
    private String msgContent;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    private Date msgDate;

}
