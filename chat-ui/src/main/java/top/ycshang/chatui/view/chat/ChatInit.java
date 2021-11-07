package top.ycshang.chatui.view.chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import top.ycshang.chatui.Main;
import top.ycshang.chatui.view.UIObject;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 22:20
 **/
public abstract class ChatInit extends UIObject {
    private static final String RESOURCE_NAME = "chat/chat.fxml";
    /**
     * 用户ID
     */
    public String userId;
    /**
     * 用户昵称
     */
    public String userNickName;
    /**
     * 用户头像
     */
    public String userHead;

    public IChatEvent chatEvent;

    /**
     * 输入框
     */
    public TextArea txtInput;

    ChatInit(IChatEvent chatEvent) {
        this.chatEvent = chatEvent;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(RESOURCE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 1243, 820);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        //设置窗口置顶
        //((Stage) scene.getWindow()).setAlwaysOnTop(true);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        // 可以预加载
        txtInput = $("txt_input", TextArea.class);
    }

    public Parent root(){
        return super.root;
    }
}
