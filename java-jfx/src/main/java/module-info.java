module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires AnimateFX;


    opens top.ycshang.java.jfx.ctrl to javafx.fxml;
    opens top.ycshang.java.jfx to javafx.fxml;
    exports top.ycshang.java.jfx;
    exports top.ycshang.java.jfx.layout;
    opens top.ycshang.java.jfx.layout to javafx.fxml;

}