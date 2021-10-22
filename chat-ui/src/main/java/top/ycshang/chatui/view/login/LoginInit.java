package top.ycshang.chatui.view.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import top.ycshang.chatui.Main;
import top.ycshang.chatui.view.UIObject;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 21:04
 **/
public abstract class LoginInit extends UIObject {

    private static final String RESOURCE_NAME = "login/login.fxml";
    public Button loginMin;
    public Button loginClose;
    public Button loginButton;
    public TextField userId;
    public PasswordField userPassword;
    protected ILoginEvent loginEvent;

    LoginInit(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;
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
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        loginMin = $("loginMin", Button.class);
        loginClose = $("loginClose", Button.class);
        loginButton = $("loginButton", Button.class);
        userId = $("userId", TextField.class);
        userPassword = $("userPassword", PasswordField.class);
    }

}