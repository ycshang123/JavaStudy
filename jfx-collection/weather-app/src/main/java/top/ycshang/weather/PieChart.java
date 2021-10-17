package top.ycshang.weather;

import com.alibaba.fastjson.JSONObject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import top.ycshang.weather.util.SystemInfoUtil;

import java.io.IOException;

/**
 * @program: jfx-collection
 * @description:饼图
 * @author: ycshang
 * @create: 2021-10-17 20:49
 **/
public class PieChart extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart();
        pieChart.setData(getChartData());
        pieChart.setTitle("系统信息");
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setClockwise(false);
        pieChart.setLabelsVisible(false);

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);
        stage.setScene(new Scene(root, 800, 500));

        stage.show();

    }

    private ObservableList<javafx.scene.chart.PieChart.Data> getChartData() {
        JSONObject message = SystemInfoUtil.getInfo();
        String mem = message.getJSONObject("memInfo").get("usageRate").toString();
        Double memInfo = Double.valueOf(mem.substring(0, mem.length() - 1));
        String jvm = message.getJSONObject("jvmInfo").get("usageRate").toString();
        Double jvmInfo = Double.valueOf(jvm.substring(0, jvm.length() - 1));
        String cpu = message.getJSONObject("cpuInfo").get("cSys").toString();
        Double cpuInfo = Double.valueOf(cpu.substring(0, cpu.length() - 1));
        ObservableList<javafx.scene.chart.PieChart.Data> answer = FXCollections.observableArrayList();
        answer.addAll(new javafx.scene.chart.PieChart.Data("memInfo的使用情况", memInfo),
                new javafx.scene.chart.PieChart.Data("jvmInfo的使用情况", jvmInfo),
                new javafx.scene.chart.PieChart.Data("cpuInfo的使用情况", cpuInfo));
        return answer;
    }
}