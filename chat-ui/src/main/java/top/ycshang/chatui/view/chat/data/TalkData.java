package top.ycshang.chatui.view.chat.data;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-23 19:37
 **/
public class TalkData {
    private String talkName;
    private String talkHead;

    public TalkData() {
    }

    public TalkData(String talkName, String talkHead) {
        this.talkName = talkName;
        this.talkHead = talkHead;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public String getTalkHead() {
        return talkHead;
    }

    public void setTalkHead(String talkHead) {
        this.talkHead = talkHead;
    }
}