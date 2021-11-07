package top.ycshang.chatui.view.login;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 21:04
 **/
public class LoginEventDefine {
    private final LoginInit loginInit;
    private final ILoginEvent loginEvent;
    private ILoginMethod loginMethod;

    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;

        loginInit.move();
        min();
        quit();
        doEventLogin();
    }

    /**
     * 最小化
     */
    private void min() {
        loginInit.loginMin.setOnAction(event -> {
            loginInit.setIconified(true);
        });
    }


    /**
     * 退出
     */
    private void quit() {
        loginInit.loginClose.setOnAction(event -> {
            loginInit.close();
            System.exit(0);
        });
    }

    /**
     * 登录
     */
    private void doEventLogin() {
        loginInit.loginButton.setOnAction(event -> {
            loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
        });
    }
}