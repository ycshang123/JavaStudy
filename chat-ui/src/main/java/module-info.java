module top.ycshang.chatui {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.chatui to javafx.fxml;
    exports top.ycshang.chatui;
    opens top.ycshang.chatui.view.login to javafx.fxml;
    exports top.ycshang.chatui.view.login;

}