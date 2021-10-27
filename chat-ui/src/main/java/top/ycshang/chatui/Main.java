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
                //用户信息
                chat.setUserInfo("100001", "尚宇驰", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg");

                // 好友 - 对话框
                chat.addTalkBox(-1, 0, "1000002", "陈蓉琪", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/crq.jpg", "秋风扫过树叶落，哪有棋盘哪有我", new Date(), false);
                chat.addTalkMsgUserLeft("1000002", "冷暖我不念你 江河知道你", new Date(), true, false, true);
                chat.addTalkMsgRight("1000002", "一个谜一样的你", new Date(), true, true, false);

                chat.addTalkBox(-1, 0, "1000003", "尚宇驰", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/syc.jpg", null, null, false);
                chat.addTalkMsgUserLeft("1000003", "可是高米店南 不见高米店南", new Date(), true, false, true);
                chat.addTalkMsgRight("1000003", "我迫切的想要呼吸 却意外的特别着迷", new Date(), true, true, false);

                // 群组
                chat.addFriendGroup("2000001", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/ssy.yjincc3ixy8.jpg");
                chat.addFriendGroup("2000002", "学习之路", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xxzl.5gkix7c0skw0.jpg");

                // 群组 - 对话框
                chat.addTalkBox(0, 1, "5307397", "松山院", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/hand-7.jpg", "", new Date(), false);
                chat.addTalkMsgRight("5307397", "美丽不美丽 可喜又可惜", new Date(), true, true, false);
                chat.addTalkMsgGroupLeft("5307397", "1000002", "陈蓉琪", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/crq.jpg", "是你不是你 梦不可及", new Date(), true, false, true);
                chat.addTalkMsgGroupLeft("5307397", "1000003", "尚宇驰", "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/syc.jpg", "有始无终的 无疾而终的", new Date(), true, false, true);

                // 好友
                chat.addFriendUser(false, "1000001", "老班", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg");
                chat.addFriendUser(false, "1000002", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/crq.1kuhpl58y1q8.jpg");
                chat.addFriendUser(false, "1000004", "杨阳", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/yy.702r5cad9x00.jpg");
                chat.addFriendUser(false, "1000005", "王林", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/wl.6ofhsqbwakc0.jpg");
                chat.addFriendUser(false, "1000003", "薛凯凯", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/xkk.1187jq22npls.jpg");

            }
        }));
        login.doShow();
    }

}