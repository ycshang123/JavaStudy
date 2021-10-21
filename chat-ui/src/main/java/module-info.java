module top.ycshang.chatui {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.chatui to javafx.fxml;
    exports top.ycshang.chatui;
}