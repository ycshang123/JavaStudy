module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.java.jfx.ctrl to javafx.fxml;
    exports top.ycshang.java.jfx;
}