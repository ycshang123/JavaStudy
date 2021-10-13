package top.ycshang.address.view;

import javafx.fxml.FXML;
import top.ycshang.address.MainApp;


/**
 * @program: address
 * @description:
 * @author: ycshang
 * @create: 2021-10-11 20:08
 **/
public class RootController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleShowBirthdayStatistics() {
        mainApp.showBirthdayStatistics();
    }

}