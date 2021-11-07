package top.ycshang.chatui.view.login;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 21:04
 **/
public class LoginView {
    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }
}