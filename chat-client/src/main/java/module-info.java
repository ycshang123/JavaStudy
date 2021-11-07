module top.ycshang.chat.client {
    requires top.ycshang.chatui;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires lombok;
    requires chat.server.agreement;
    requires io.netty.all;
    requires fastjson;

    opens top.ycshang.chat.client to javafx.fxml;
    exports top.ycshang.chat.client;
}