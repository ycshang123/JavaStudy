package top.ycshang.trayicon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-29 22:14
 **/
public class CanvasApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Canvas");
        Group group = new Group();
        Canvas canvas = new Canvas(500, 300);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawShapes(context);
        group.getChildren().add(canvas);
        stage.setScene(new Scene(group));
        stage.show();
    }

    private void drawShapes(GraphicsContext context) {
        context.setFill(Color.GREEN);
        context.setStroke(Color.BLUE);
        context.setLineWidth(5);
        context.strokeLine(40, 10, 10, 40);
        context.fillOval(10, 60, 30, 30);
        context.strokeOval(60, 60, 30, 30);
        context.fillRoundRect(110, 60, 30, 30, 10, 10);
        context.strokeRoundRect(160, 60, 30, 30, 10, 10);
        context.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        context.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        context.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        context.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        context.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        context.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        context.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        context.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        context.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);

    }
}