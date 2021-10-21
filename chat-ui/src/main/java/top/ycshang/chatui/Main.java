package top.ycshang.chatui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-21 22:30
 **/
public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 420);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}