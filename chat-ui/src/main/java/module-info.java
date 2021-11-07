module top.ycshang.chatui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign;


    opens top.ycshang.chatui to javafx.fxml;
    exports top.ycshang.chatui;

    opens top.ycshang.chatui.view to javafx.fxml;
    exports top.ycshang.chatui.view;

    opens top.ycshang.chatui.view.login to javafx.fxml;
    exports top.ycshang.chatui.view.login;

    opens top.ycshang.chatui.view.chat to javafx.fxml;
    exports top.ycshang.chatui.view.chat;

    exports top.ycshang.chatui.util;
    exports top.ycshang.chatui.param;


}