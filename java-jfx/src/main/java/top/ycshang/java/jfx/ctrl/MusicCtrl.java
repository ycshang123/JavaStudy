package top.ycshang.java.jfx.ctrl;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-10-03 21:35
 **/
public class MusicCtrl implements Initializable {
    public StackPane root;
    public FlowPane firstPane;
    public GridPane secondPane;
    public AnchorPane thirdPane;
    public WebView browser;

    private Stage stage;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * 弹出框按钮单击事件
     */
    public void onBtnAlertClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("你好");
        alert.show();
    }

    /**
     * 接收主方法传递的stage对象
     *
     * @param stage stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    /**
     * 顶部标题栏鼠标按下事件，获得当前鼠标位置
     *
     * @param event 鼠标事件对象
     */
    public void onPressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    /**
     * 顶部标题栏拖拽事件，根据鼠标位置和偏移重置窗体位置
     *
     * @param event 鼠标事件对象
     */
    public void onDragged(MouseEvent event) {
        stage.setX(event.getScreenX() - xOffset);
        if (event.getScreenY() - yOffset < 0) {
            stage.setY(0);
        } else {
            stage.setY(event.getScreenY() - yOffset);
        }
    }


    /**
     * 最小化窗体
     *
     * @param event 鼠标事件对象
     */
    public void onMinClicked(MouseEvent event) {
        stage.setIconified(true);
    }

    /**
     * 关闭窗体
     *
     * @param event 鼠标事件对象
     */
    public void onCloseClicked(MouseEvent event) {
        stage.close();
    }

    /**
     * 显示右侧第一个面板
     *
     * @param actionEvent actionEvent
     */
    public void showFirstPane(ActionEvent actionEvent) {
        new FadeIn(firstPane).play();
        firstPane.setVisible(true);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
    }

    /**
     * 显示右侧第二个面板
     *
     * @param actionEvent actionEvent
     */
    public void showSecondPane(ActionEvent actionEvent) {
        new FadeIn(secondPane).play();
        secondPane.setVisible(true);
        firstPane.setVisible(false);
        thirdPane.setVisible(false);
    }

    /**
     * 显示右侧第三个面板
     *
     * @param actionEvent actionEvent
     */
    public void showThirdPane(ActionEvent actionEvent) {
        new FadeIn(thirdPane).play();
        thirdPane.setVisible(true);
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        WebEngine webEngine = browser.getEngine();
        webEngine.load("https://ycshang123.github.io/");
    }
}