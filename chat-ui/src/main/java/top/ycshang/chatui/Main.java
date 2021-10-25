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
                chat.setUserInfo("100001","尚宇驰","https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg");
                chat.addTalkBox(-1, 0, "10001", "陶然然", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg", "", new Date(), false);
                chat.addTalkBox(-1, 0, "10002", "杨阳", "https://wx4.sinaimg.cn/mw690/00669kengy1gumd7zbqknj60i20i1tde02.jpg", "函数应该做一件事。做好这件事。只能做这一件事。", new Date(), false);
                chat.addTalkMsgRight("10002", "计算机科学领域的所有问题都可以通过其他方式间接解决。", new Date(), true, false, true);
                chat.addTalkMsgUserLeft("10002", "只有两种编程语言：大家抱怨的和没人用的。", new Date(), true, false, true);
                chat.addTalkBox(-1, 0, "10003", "陈蓉琪", "https://wx3.sinaimg.cn/mw690/00669kengy1gux8qzbuerj60fu0b2wfe02.jpg", "愚者困惑，智者提问。", new Date(), false);
                chat.addTalkMsgRight("10003", " Java之于JavaScript如同Car之于Carpet。", new Date(), true, false, true);
                chat.addTalkMsgUserLeft("10003", "计算机善于遵循指令，但不善于理解你的思维。", new Date(), true, false, true);
                chat.addTalkBox(-1, 0, "10004", "王林", "https://wx2.sinaimg.cn/mw690/00669kengy1gumd86b16ij60fh0fh76f02.jpg", "我坚信，自我教育是唯一的教育形式。", new Date(), false);
                chat.addTalkBox(-1, 0, "10006", "盏茶作酒", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/7.309m5bf9shq0.jpg", "视代码如诗词，勿要做无所谓的堆砌", new Date(), false);
                chat.addTalkBox(0, 1, "5001501", "软件1851", "https://wx4.sinaimg.cn/mw690/00669kengy1gux81wg6idj60zk0smnbv02.jpg", "一个人可以走得更快，一群人可以走得更远", new Date(), false);
                chat.addTalkBox(0, 1, "5001502", "松山院", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag2.5l6c7b2fvv40.jpg", "保持热枕，善于思考，提升素养", new Date(), true);
                chat.addTalkMsgGroupLeft("5001502", "10001", "陶然然", "https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/avatar/me.5y3oh3q7cy00.jpg", "没有优秀的团队，无法打造出优秀的软件。大部分的软件团队看上去就像内部不和谐的家庭。。", new Date(), true, true, true);
                chat.addTalkMsgRight("5001502",   "拙劣的程序员担心代码。好的程序员担心数据结构及它们的关系。", new Date(), false, true, true);
                chat.addTalkMsgGroupLeft("5001502", "10003", "陈蓉琪", "https://wx3.sinaimg.cn/mw690/00669kengy1gux8qzbuerj60fu0b2wfe02.jpg", "优良设计创造价值的速度，快于其增加成本的速度。", new Date(), false, true, true);
                chat.addTalkMsgGroupLeft("5001502", "10002", "杨阳", "https://wx4.sinaimg.cn/mw690/00669kengy1gumd7zbqknj60i20i1tde02.jpg", "为了理解递归，我们首先要理解的是递归。", new Date(), true, true, true);
                chat.addTalkMsgGroupLeft("5001502", "10004", "王林", "https://wx2.sinaimg.cn/mw690/00669kengy1gumd86b16ij60fh0fh76f02.jpg", " 理论上，理论和实践是没有差异的。但实践中，是有的。", new Date(), true, true, true);
                chat.addTalkBox(0, 1, "5001503", "极客营", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/pag3.1ao7erlnhbcw.jpg", "每名程序员都是作家。", new Date(), false);
                chat.addTalkBox(0, 1, "5001504", "你我之书", "https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.6cr8zznpvjc0.jpg", "一起❤", new Date(), false);
            }
        }));
        login.doShow();
    }

}