package top.ycshang.chat.client.application;


import top.ycshang.chatui.view.chat.IChatMethod;
import top.ycshang.chatui.view.login.ILoginMethod;

/**
 * 网络服务
 *
 * @author ycshang
 */
public class UIService {


    private ILoginMethod login;
    private IChatMethod chat;

    public ILoginMethod getLogin() {
        return login;
    }

    public void setLogin(ILoginMethod login) {
        this.login = login;
    }

    public IChatMethod getChat() {
        return chat;
    }

    public void setChat(IChatMethod chat) {
        this.chat = chat;
    }
}
