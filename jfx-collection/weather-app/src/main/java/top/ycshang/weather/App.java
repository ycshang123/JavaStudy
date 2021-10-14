package top.ycshang.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-13 18:51
 **/
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/icom.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Weather APP");
        stage.setScene(scene);
        stage.show();
    }
}