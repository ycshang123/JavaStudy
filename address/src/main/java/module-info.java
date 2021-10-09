module top.ycshang.address {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.address to javafx.fxml;
    exports top.ycshang.address;
    exports top.ycshang.address.view;
    opens top.ycshang.address.view to javafx.fxml;
}