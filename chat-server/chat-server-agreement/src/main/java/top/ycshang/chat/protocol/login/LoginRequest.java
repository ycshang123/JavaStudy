package top.ycshang.chat.protocol.login;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ycshang.chat.protocol.Command;
import top.ycshang.chat.protocol.Packet;

/**
 * 登录请求
 *
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class LoginRequest extends Packet {

    private String userId;
    private String userPassword;

    public LoginRequest(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }


    @Override
    public Byte getCommand() {
        return Command.LoginRequest;
    }

}
