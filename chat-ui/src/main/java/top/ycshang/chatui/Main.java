package top.ycshang.chatui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import top.ycshang.chatui.view.chat.ChatController;
import top.ycshang.chatui.view.chat.IChatEvent;
import top.ycshang.chatui.view.chat.IChatMethod;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        ILoginMethod login = new LoginController(((userId, userPassword) -> {
            if ("admin".equals(userId) && "123123".equals(userPassword)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.titleProperty().set("提示");
                alert.headerTextProperty().set("登录成功");
                alert.showAndWait();
                IChatMethod chat = new ChatController(new IChatEvent() {
                });
                chat.doShow();
                // 用户信息
                chat.setUserInfo("1000001", "盏茶作酒", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/me.583hffnfvkw0.png");

                // 好友 - 对话框
                chat.addTalkBox(-1, 0, "1000003", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg", "", new Date(), false);
                chat.addTalkMsgUserLeft("1000003", "明天我满课", new Date(), true, false, false);
                chat.addTalkMsgRight("1000003", "我也是！还碰不了电脑~~~", new Date(), true, true, false);
                // 群组
                chat.addFriendGroup("2000001", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/ssy.yjincc3ixy8.jpg");
                chat.addFriendGroup("2000002", "学习之路", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xxzl.5gkix7c0skw0.jpg");

                // 群组 - 对话框
                chat.addTalkBox(0, 1, "2000001", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/ssy.yjincc3ixy8.jpg", "", new Date(), false);
                chat.addTalkMsgGroupLeft("2000001", "1000003", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg", "什么时候解法呀", new Date(), true, false, true);
                chat.addTalkMsgRight("2000001", "想解封的第N天", new Date(), true, true, true);
                chat.addTalkMsgGroupLeft("2000001", "1000006", "王林", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/wl.6ofhsqbwakc0.jpg", "再不解封，我受不了了", new Date(), true, false, true);

                // 好友
                chat.addFriendUser(false, "1000002", "老班", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg");
                chat.addFriendUser(false, "1000003", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg");
                chat.addFriendUser(false, "1000004", "杨阳", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/yy.702r5cad9x00.jpg");
                chat.addFriendUser(false, "1000005", "薛凯凯", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xkk.1187jq22npls.jpg");
                chat.addFriendUser(false, "1000006", "王林", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/wl.6ofhsqbwakc0.jpg");

                ////用户信息
                //chat.setUserInfo("1000011", "尚宇驰", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg");
                //
                //chat.addTalkBox(-1, 0, "1000001", "老班", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg", "开到荼蘼", new Date(), false);
                //// 好友 - 对话框
                //chat.addTalkBox(-1, 0, "1000002", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg", "有需求找我", new Date(), false);
                //chat.addTalkMsgUserLeft("1000002", "明天我满课", new Date(), true, false, true);
                //chat.addTalkMsgRight("1000002", "我也满课，还是用不了电脑的那种", new Date(), true, true, false);
                //
                //chat.addTalkBox(-1, 0, "1000004", "杨阳", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/yy.702r5cad9x00.jpg", null, null, false);
                //chat.addTalkMsgUserLeft("1000003", "中午带个饭", new Date(), true, false, true);
                //chat.addTalkMsgRight("1000003", "ok", new Date(), true, true, false);
                //
                //// 群组
                //chat.addFriendGroup("2000001", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/ssy.yjincc3ixy8.jpg");
                //chat.addFriendGroup("2000002", "学习之路", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xxzl.5gkix7c0skw0.jpg");
                //
                //// 群组 - 对话框
                //chat.addTalkBox(0, 1, "5307397", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/ssy.yjincc3ixy8.jpg", "", new Date(), false);
                //chat.addTalkMsgRight("2000001", "什么时候可以解封呀", new Date(), true, true, false);
                //chat.addTalkMsgGroupLeft("2000001", "1000002", "杨阳", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/yy.702r5cad9x00.jpg", "两周已经过去了……", new Date(), true, false, true);
                //chat.addTalkMsgGroupLeft("2000001", "1000003", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg", "已经线下课了！", new Date(), true, false, true);
                //chat.addTalkMsgGroupLeft("2000001", "1000004", "王林", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/wl.6ofhsqbwakc0.jpg", "可以解封了吧", new Date(), true, false, true);
                //chat.addTalkMsgGroupLeft("2000001", "10000011", "尚宇驰", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg", "想出去的第N天", new Date(), true, false, true);
                //
                //// 好友
                //chat.addFriendUser(false, "1000001", "老班", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg");
                //chat.addFriendUser(false, "1000002", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg");
                //chat.addFriendUser(false, "1000004", "杨阳", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/yy.702r5cad9x00.jpg");
                //chat.addFriendUser(false, "1000005", "王林", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/wl.6ofhsqbwakc0.jpg");
                //chat.addFriendUser(false, "1000003", "薛凯凯", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xkk.1187jq22npls.jpg");

            }
        }));
        login.doShow();
    }

}