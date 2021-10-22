package top.ycshang.chatui.view.login;

/**
 * @program: chat-ui
 * @description: 事件接口类，具体实现交给调用方。例如我们在点击登陆后将属于窗体的功能处理完毕后，实际的验证交给外部
 * @author: ycshang
 * @create: 2021-10-22 21:03
 **/
public interface ILoginEvent {
    /**
     * 登录验证
     *
     * @param userId
     * @param userPassword
     */
    void doLoginCheck(String userId, String userPassword);
}