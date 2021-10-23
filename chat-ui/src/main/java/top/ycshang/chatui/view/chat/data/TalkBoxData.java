package top.ycshang.chatui.view.chat.data;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-23 19:37
 **/
public class TalkBoxData {
    private String talkId;
    private Integer talkType;
    private String talkBName;
    private String talkHead;

    public TalkBoxData(String talkId, Integer talkType, String talkBName, String talkHead) {
        this.talkId = talkId;
        this.talkType = talkType;
        this.talkBName = talkBName;
        this.talkHead = talkHead;
    }
}