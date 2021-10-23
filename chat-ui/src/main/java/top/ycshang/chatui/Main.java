package top.ycshang.chatui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import top.ycshang.chatui.view.chat.ChatController;
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
                IChatMethod chat = new ChatController();
                chat.doShow();
                chat.addTalkBox(-1, 0, "10001", "陶然然", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg", "开到荼蘼", new Date(), false);
                chat.addTalkBox(-1, 0, "10002", "杨阳", "https://wx4.sinaimg.cn/mw690/00669kengy1gumd7zbqknj60i20i1tde02.jpg", "函数应该做一件事。做好这件事。只能做这一件事。", new Date(), false);
                chat.addTalkBox(-1, 0, "10003", "陈蓉琪", "https://wx3.sinaimg.cn/mw690/00669kengy1gux8qzbuerj60fu0b2wfe02.jpg", "愚者困惑，智者提问。", new Date(), false);
                chat.addTalkBox(-1, 0, "10004", "王林", "https://wx2.sinaimg.cn/mw690/00669kengy1gumd86b16ij60fh0fh76f02.jpg", "我坚信，自我教育是唯一的教育形式。", new Date(), false);
                chat.addTalkBox(-1, 0, "10005", "尚宇驰", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg", "我所学到的一切，都是从书本上得来的。", new Date(), false);
                chat.addTalkBox(-1, 0, "10006", "盏茶作酒", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/7.309m5bf9shq0.jpg", "视代码如诗词，勿要做无所谓的堆砌", new Date(), false);
                chat.addTalkBox(0, 1, "5001501", "软件1851", "https://wx4.sinaimg.cn/mw690/00669kengy1gux81wg6idj60zk0smnbv02.jpg", "一个人可以走得更快，一群人可以走得更远", new Date(), false);
                chat.addTalkBox(0, 1, "5001502", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag2.5l6c7b2fvv40.jpg", "保持热枕，善于思考，提升素养", new Date(), false);
                chat.addTalkBox(0, 1, "5001503", "极客营", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag3.1ao7erlnhbcw.jpg", "每名程序员都是作家。", new Date(), false);
                chat.addTalkBox(0, 1, "5001504", "你我之书", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg", "一起❤", new Date(), true);
            }
        }));
        login.doShow();
    }

}