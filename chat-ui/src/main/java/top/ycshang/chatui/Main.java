package top.ycshang.chatui;

import javafx.application.Application;
import javafx.stage.Stage;
import top.ycshang.chatui.view.chat.ChatController;
import top.ycshang.chatui.view.chat.IChatMethod;

import java.io.IOException;

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

    //@Override
    //public void start(Stage stage) throws IOException {
    //    ILoginMethod login = new LoginController((userId, userPassword) -> {
    //        System.out.println("登录 userId：" + userId + "userPassword：" + userPassword);
    //    });
    //
    //    login.doShow();
    //}
    @Override
    public void start(Stage stage) throws IOException {
        IChatMethod chat = new ChatController();
        chat.doShow();
    }

}