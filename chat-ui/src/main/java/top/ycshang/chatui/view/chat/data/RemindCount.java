package top.ycshang.chatui.view.chat.data;

/**
 * @program: chat-ui
 * @description:消息提醒
 * @author: ycshang
 * @create: 2021-10-23 19:36
 **/
public class RemindCount {

    /**
     * 消息提醒条数
     */
    private int count = 0;

    public RemindCount() {
    }

    public RemindCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}