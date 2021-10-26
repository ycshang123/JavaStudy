package top.ycshang.trayicon;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @program: jfx-collection
 * @description: 过渡动画举例
 * @author: ycshang
 * @create: 2021-10-26 21:25
 **/
public class FillTransitionSample extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage)  {
        stage.setTitle("过渡动画");
        Group  root = new Group();
        Scene scene = new Scene(root,500,400, Color.WHITE);
        Group group = new Group();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4,0.4,0.4));

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(250.0f);
        ellipse.setCenterY(150.0f);
        ellipse.setRadiusY(50.0f);
        ellipse.setRadiusX(100.0f);
        ellipse.setEffect(dropShadow);

        FillTransition fillTransition =new FillTransition(Duration.millis(3000),ellipse,Color.PINK,Color.GRAY);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        group.getChildren().add(ellipse);

        root.getChildren().add(group);
        stage.setScene(scene);
        stage.show();

    }
}