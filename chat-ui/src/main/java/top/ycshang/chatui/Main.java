package top.ycshang.chatui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import top.ycshang.chatui.view.chat.ChatController;
import top.ycshang.chatui.view.chat.IChatEvent;
import top.ycshang.chatui.view.chat.IChatMethod;
import top.ycshang.chatui.view.chat.group_bar_friend.ElementFriendNewUser;
import top.ycshang.chatui.view.login.ILoginMethod;
import top.ycshang.chatui.view.login.LoginController;

import java.io.IOException;
import java.util.Date;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-21 22:30
 **/
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // 事件类实现并注入
        IChatMethod chat = new ChatController(new IChatEvent() {
            @Override
            public void doQuit() {
                System.out.println("退出操作！");
            }

            @Override
            public void doSendMsg(String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate) {
                System.out.println("发送消息");
                System.out.println("userId：" + userId);
                System.out.println("talkType[0好友/1群组]：" + talkType);
                System.out.println("talkId：" + talkId);
                System.out.println("msg：" + msg);
                System.out.println("msgType[0文字消息/1固定表情]：" + msgType);
            }

            @Override
            public void doEventAddTalkUser(String userId, String userFriendId) {
                System.out.println("填充到聊天窗口[好友] userFriendId：" + userFriendId);
            }

            @Override
            public void doEventAddTalkGroup(String userId, String groupId) {
                System.out.println("填充到聊天窗口[群组] groupId：" + groupId);
            }

            @Override
            public void doEventDelTalkUser(String userId, String talkId) {
                System.out.println("删除对话框：" + talkId);
            }

            @Override
            public void addFriendNew(String userId, ListView<Pane> listView) {
                System.out.println("新的朋友");
                // 添加朋友
                listView.getItems().add(new ElementFriendNewUser("1000004", "彼岸花开", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/1.jpg", 0).pane());
                listView.getItems().add(new ElementFriendNewUser("1000005", "开到荼蘼", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/2.jpg", 1).pane());
            }

            @Override
            public void doFriendNewSearch(String userId, String text) {
                System.out.println("搜索好友：" + text);
            }

            @Override
            public void doEventAddNewUser(String userId, String friendId) {
                System.out.println("添加好友：" + friendId);
            }
        });

        chat.doShow();
        chat.setUserInfo("1000001", "陶然然", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg");

        // 好友
        chat.addFriendUser(false, "1000002", "陈蓉琪", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/crq.jpg");
        chat.addFriendUser(true, "1000003", "尚宇驰", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/syc.jpg");

        // 群组
        chat.addFriendGroup("2000001", "松山院", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/hand-7.jpg");
        chat.addFriendGroup("2000002", "达摩院", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/hand-2.jpg");

        // 好友 - 对话框
        chat.addTalkBox(-1, 0, "1000002", "陈蓉琪", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/crq.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000002", "冷暖我不念你", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000002", "一个谜一样的你", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000002", "江河知道你", 0, new Date(), true, false, true);

        chat.addTalkBox(-1, 0, "1000003", "尚宇驰", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/syc.jpg", null, null, false);
        chat.addTalkMsgUserLeft("1000003", "却意外的特别着迷", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000003", "我迫切的想要呼吸", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000003", "可是高米店南 不见高米店南", 0, new Date(), true, false, true);

        // 群组 - 对话框
        chat.addTalkBox(0, 1, "2000001", "松山院", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/hand-7.jpg", "", new Date(), false);
        chat.addTalkMsgGroupLeft("2000001", "1000002", "陈蓉琪", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/crq.jpg", "是你不是你 梦不可及", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("2000001", "美丽不美丽 可喜又可惜", 0, new Date(), true, true, true);
        chat.addTalkMsgGroupLeft("2000001", "1000003", "尚宇驰", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/syc.jpg", "有始无终的 无疾而终的", 0, new Date(), true, false, false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


