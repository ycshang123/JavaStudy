module top.ycshang.notepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens top.ycshang.notepad to javafx.fxml;
    exports top.ycshang.notepad;
    opens top.ycshang.notepad.view to javafx.fxml;
    exports top.ycshang.notepad.view;
}