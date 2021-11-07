package top.ycshang.chat.protocol.login;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ycshang.chat.protocol.Command;
import top.ycshang.chat.protocol.Packet;

/**
 * 重连请求
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class ReconnectRequest extends Packet {

    private String userId;

    public ReconnectRequest(String userId) {
        this.userId = userId;
    }

    @Override
    public Byte getCommand() {
        return Command.ReconnectRequest;
    }
}
