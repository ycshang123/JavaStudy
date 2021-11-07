package top.ycshang.chat.client.event;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.ycshang.chat.client.infrastructure.util.BeanUtil;
import top.ycshang.chat.client.infrastructure.util.CacheUtil;
import top.ycshang.chat.protocol.login.LoginRequest;
import top.ycshang.chatui.view.login.ILoginEvent;

/**
 * 事件实现；登陆窗口
 *
 * @author ycshang
 */
@Slf4j
public class LoginEvent implements ILoginEvent {

    @Override
    public void doLoginCheck(String userId, String userPassword) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new LoginRequest(userId, userPassword));
        CacheUtil.userId = userId;
    }

}
