package top.ycshang.java.jfx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @program: java-jfx
 * @description: 网格布局
 * @author: ycshang
 * @create: 2021-10-05 20:49
 **/
public class GridPaneExample extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Email");
        Text text1 = new Text("Password");
        TextField textField = new TextField();
        TextField textField1 = new TextField();
        Button button = new Button("Submit");
        Button button1 = new Button("Clear");


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text, 0, 0);
        gridPane.add(textField, 1, 0);
        gridPane.add(text1, 0, 1);
        gridPane.add(textField1, 1, 1);
        gridPane.add(button, 0, 2);
        gridPane.add(button1, 1, 2);

        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Grid Pane Example");
        stage.setScene(scene);
        stage.show();


    }
}