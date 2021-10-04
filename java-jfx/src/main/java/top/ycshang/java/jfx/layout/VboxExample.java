package top.ycshang.java.jfx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @program: java-jfx
 * @description: 竖直盒子布局
 * @author: ycshang
 * @create: 2021-10-04 19:47
 **/
public class VboxExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        Button playButton = new Button("play");
        Button stopButton = new Button("stop");

        VBox vBox = new VBox();
        vBox.setSpacing(10);


        VBox.setMargin(textField, new Insets(20, 20, 20, 20));
        VBox.setMargin(playButton, new Insets(20, 20, 20, 20));
        VBox.setMargin(stopButton, new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(textField, playButton, stopButton);

        Scene scene = new Scene(vBox, 400, 300);
        stage.setTitle("Vbox Example");
        stage.setScene(scene);
        stage.show();
    }
}