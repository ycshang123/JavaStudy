module top.ycshang.trayicon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.web;

    opens top.ycshang.trayicon to javafx.fxml;
    exports top.ycshang.trayicon;
}