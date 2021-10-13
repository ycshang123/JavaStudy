package top.ycshang.java.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @program: java-jfx
 * @description: 边框布局
 * @author: ycshang
 * @create: 2021-10-04 21:14
 **/
public class BorderPaneExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new TextField("Top"));
        borderPane.setBottom(new TextField("Bottom"));
        borderPane.setLeft(new TextField("Left"));
        borderPane.setRight(new TextField("Right"));
        borderPane.setCenter(new TextField("Center"));


        Scene scene = new Scene(borderPane, 400, 300);
        stage.setTitle("BorderPane Example");
        stage.setScene(scene);
        stage.show();

    }
}