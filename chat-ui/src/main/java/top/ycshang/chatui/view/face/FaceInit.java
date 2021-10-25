package top.ycshang.chatui.view.face;

/**
 * @program: chat-ui
 * @description: 初始化表情框
 * @author: ycshang
 * @create: 2021-10-25 18:42
 **/

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import top.ycshang.chatui.Main;
import top.ycshang.chatui.view.UIObject;
import top.ycshang.chatui.view.chat.ChatInit;
import top.ycshang.chatui.view.chat.IChatEvent;
import top.ycshang.chatui.view.chat.IChatMethod;

import java.io.IOException;
import java.util.Objects;
public abstract class FaceInit extends UIObject {

    private static final String RESOURCE_NAME = "face/face.fxml";

    public Pane rootPane;
    public ChatInit chatInit;
    public IChatEvent chatEvent;
    public IChatMethod chatMethod;

    FaceInit(final UIObject obj) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(RESOURCE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 模态窗口
        initModality(Modality.APPLICATION_MODAL);
        initOwner(obj);
        //初始化页面和事件
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        rootPane = $("face", Pane.class);
    }

    public Parent root() {
        return super.root;
    }

}