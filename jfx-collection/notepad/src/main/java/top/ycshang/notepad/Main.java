package top.ycshang.notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-20 22:44
 **/
public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/notepad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("记事本");
        stage.setScene(scene);
        stage.show();
    }
}