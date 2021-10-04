module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires AnimateFX;


    opens top.ycshang.java.jfx.ctrl to javafx.fxml;
    exports top.ycshang.java.jfx;
    opens top.ycshang.java.jfx to javafx.fxml;
}