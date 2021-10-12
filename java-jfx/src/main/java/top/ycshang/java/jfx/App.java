package top.ycshang.java.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import top.ycshang.java.jfx.config.AppConfig;
import top.ycshang.java.jfx.ctrl.MusicCtrl;
import top.ycshang.java.jfx.ctrl.ToDoCtrl;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-09-30 21:38
 **/
public class App extends Application {

    public static void main(String[] args) {
            AppConfig.init();
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // 加载并创建主场景
        //Parent root = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("fxml/main.fxml")));
        // 加载外部样式，这样窗口中所有组件可用，绑定在fxml组件上的样式只能本组件可用
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(App.class.getResource("fxml/todo.fxml")));
        Parent root = loader.load();
        root.getStylesheets().add(Objects.requireNonNull(App.class.getResource("css/todo.css")).toExternalForm());

        ToDoCtrl controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root, AppConfig.stageWidth, AppConfig.stageHeight);
        stage.setScene(scene);
        stage.setResizable(AppConfig.stageResizable);
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream(AppConfig.icon))));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}