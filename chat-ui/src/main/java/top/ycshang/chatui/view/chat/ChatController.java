package top.ycshang.chatui.view.chat;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 22:19
 **/
public class ChatController extends ChatInit implements IChatMethod {

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEventDefine() {
        ChatEventDefine chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }
}