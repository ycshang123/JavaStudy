package top.ycshang.java.jfx.effect;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-10-07 20:08
 **/
public class ColorAdjustEffectExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/1.22asgtnxynvk.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(50);
        imageView.setFitWidth(500);
        imageView.setFitHeight(400);


        imageView.setPreserveRatio(true);
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.9);
        colorAdjust.setHue(0.01);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(0.1);
        imageView.setEffect(colorAdjust);


        Group root = new Group(imageView);
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Color Adjust effect example");
        stage.setScene(scene);
        stage.show();
    }
}