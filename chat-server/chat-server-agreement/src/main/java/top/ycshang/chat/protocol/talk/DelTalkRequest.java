package top.ycshang.chat.protocol.talk;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ycshang.chat.protocol.Command;
import top.ycshang.chat.protocol.Packet;

/**
 * 删除对话框请求
 *
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class DelTalkRequest extends Packet {

    private String userId;
    private String talkId;

    public DelTalkRequest() {
    }

    public DelTalkRequest(String userId, String talkId) {
        this.userId = userId;
        this.talkId = talkId;
    }

    @Override
    public Byte getCommand() {
        return Command.DelTalkRequest;
    }
}
