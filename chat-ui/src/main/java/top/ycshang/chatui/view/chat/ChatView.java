package top.ycshang.chatui.view.chat;

import top.ycshang.chatui.view.chat.ChatInit;
import top.ycshang.chatui.view.chat.IChatEvent;

/**
 * 窗体的展示
 *
 * @author ycshang
 */
public class ChatView {

    private ChatInit chatInit;
    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
    }

    public ChatView() {
    }

    public ChatInit getChatInit() {
        return chatInit;
    }

    public void setChatInit(ChatInit chatInit) {
        this.chatInit = chatInit;
    }

    public IChatEvent getChatEvent() {
        return chatEvent;
    }

    public void setChatEvent(IChatEvent chatEvent) {
        this.chatEvent = chatEvent;
    }
}