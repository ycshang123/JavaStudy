package top.ycshang.weather.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import top.ycshang.weather.util.ApiConnector;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-13 18:52
 **/
public class PrimaryController {
    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    @FXML
    void getWeatherData(ActionEvent event) {
        JSONObject todayWeather = getTodayWeatherInformation(getWoeid());
        System.out.println(todayWeather);
        weatherText.setText(
                "Current Date: " + todayWeather.get("applicable_date") +
                        "\nCurrent city: " + cityInput.getText() +
                        "\nCurrent temperature: " +
                        todayWeather.get("the_temp") +
                        "\nMax temperature: " +
                        todayWeather.get("max_temp") +
                        "\nMin temperature: " +
                        todayWeather.get("min_temp") +
                        "\nWind speed: " + todayWeather.get("wind_speed")
        );
    }

    public String getWoeid() {
        String cityApi = "https://www.metaweather.com/api/location/search/?query=";
        ApiConnector apiConnector = new ApiConnector(cityApi);
        JSONObject jsonObject = (JSONObject) (apiConnector.getJsonArray(cityInput.getText())).get(0);
        return jsonObject.get("woeid").toString();
    }

    public JSONObject getTodayWeatherInformation(String woeid) {
        String weatherApi = "https://www.metaweather.com/api/location/";
        ApiConnector apiConnectorWeather = new ApiConnector(weatherApi);
        JSONObject weatherJsonObject =
                apiConnectorWeather.getJsonObject(woeid + "/");
        JSONArray weatherArray = (JSONArray)
                weatherJsonObject.get("consolidated_weather");
        return (JSONObject) weatherArray.get(0);
    }

}