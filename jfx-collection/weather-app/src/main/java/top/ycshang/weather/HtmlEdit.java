package top.ycshang.weather;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-29 23:09
 **/
public class HtmlEdit extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("HTMLEditor");
        String text = "<html><body><h1>学习之路</h1></body></html>";
        TilePane tilePane = new TilePane();
        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setHtmlText(text);
        tilePane.getChildren().add(htmlEditor);
        Scene scene = new Scene(tilePane, 600, 500);
        stage.setScene(scene);
        stage.show();
    }
}
