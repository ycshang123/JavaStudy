package top.ycshang.java.jfx.ctrl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @program: java-jfx
 * @description:主界面控制器
 * @author: ycshang
 * @create: 2021-09-30 21:39
 **/
public class MainCtrl implements Initializable {

    public Pane rootPane;

    public Button btnAlert;

    public Button dateBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize: " + location.getPath());
    }

    /**
     * 弹出框按钮单击事件
     *
     * @param actionEvent 事件对象
     */
    public void onBtnAlertClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("你好");
        alert.show();
    }

    /**
     * 日历
     */
    public void showDatePicker(ActionEvent actionEvent) {
        Stage stage = new Stage();
        VBox vbox = new VBox(20);
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);

        DatePicker checkInDatePicker = new DatePicker();

        vbox.getChildren().add(checkInDatePicker);

        stage.show();


    }


}