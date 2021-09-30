package top.ycshang.java.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import top.ycshang.java.jfx.config.AppConfig;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-09-30 21:38
 **/
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // 加载并创建主场景
        Parent root = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("fxml/main.fxml")));
        // 加载外部样式，这样窗口中所有组件可用，绑定在fxml组件上的样式只能本组件可用
        root.getStylesheets().add(Objects.requireNonNull(App.class.getResource("css/main.css")).toExternalForm());
        Scene scene = new Scene(root, AppConfig.stageWidth, AppConfig.stageHeight);
        // 设置窗口信息
        stage.setTitle(AppConfig.title);
        stage.setResizable(AppConfig.stageResizable);
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream(AppConfig.icon))));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        AppConfig.init();
        launch();
    }
}