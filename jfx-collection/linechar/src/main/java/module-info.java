module top.ycshang.linechar {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.linechar to javafx.fxml;
    exports top.ycshang.linechar;
}