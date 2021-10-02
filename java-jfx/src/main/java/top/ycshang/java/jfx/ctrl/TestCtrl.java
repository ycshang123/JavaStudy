package top.ycshang.java.jfx.ctrl;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

/**
 * @program: java-jfx
 * @description:
 * @author: ycshang
 * @create: 2021-10-02 14:32
 **/
public class TestCtrl {
    public Button btn;
    public DatePicker datePicker;

    public void onBtnClick(ActionEvent actionEvent) {
        datePicker.setVisible(!datePicker.isVisible());
    }
}