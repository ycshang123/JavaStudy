module top.ycshang.weather.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens top.ycshang.weather to javafx.fxml;
    exports top.ycshang.weather;
    opens top.ycshang.weather.view to javafx.fxml;
    exports top.ycshang.weather.view;
    exports top.ycshang.weather.util;
}