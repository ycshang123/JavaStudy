package top.ycshang.java.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-10-04 19:53
 **/
public class TextFlowExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Welcome to JavaFX~");
        text.setFont(new Font(15));
        text.setFill(Color.DARKSLATEBLUE);
        Text text1 = new Text("We provide free tutorials for readers in various technologies");
        text1.setFont(new Font(15));
        text1.setFill(Color.DARKGOLDENROD);
        Text text2 = new Text("\n Recently we started free video tutorials too");
        text2.setFont(new Font(15));
        text2.setFill(Color.DARKGRAY);
        Text text3 = new Text("We believe in easy learning");
        text3.setFont(new Font(15));
        text3.setFill(Color.MEDIUMVIOLETRED);

        TextFlow textFlow = new TextFlow();
        textFlow.setTextAlignment(TextAlignment.JUSTIFY);
        textFlow.setPrefSize(600, 300);
        textFlow.setLineSpacing(5.0);

        textFlow.getChildren().addAll(text, text1, text2, text3);
        Scene scene = new Scene(textFlow, 400, 300);
        stage.setTitle("TextFlow Pane Example");
        stage.setScene(scene);
        stage.show();

    }
}