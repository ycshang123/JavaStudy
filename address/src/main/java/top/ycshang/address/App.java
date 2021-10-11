package top.ycshang.address;

import javafx.application.Application;
import top.ycshang.address.config.AppConfig;

/**
 * @program: address
 * @description:
 * @author: ycshang
 * @create: 2021-10-08 22:36
 **/
public class App {
    public static void main(String[] args) {
        AppConfig.init();

        Application.launch(MainApp.class);
    }
}