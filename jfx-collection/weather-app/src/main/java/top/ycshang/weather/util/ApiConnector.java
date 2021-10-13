package top.ycshang.weather.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import top.ycshang.weather.config.AppConstant;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-13 19:02
 **/
public class ApiConnector {
    private final String urlString;

    public ApiConnector(String urlString) {
        this.urlString = urlString;
    }

    public JSONArray getJsonArray(String query) {
        try {
            URL url = new URL(urlString + query);
            //请求指定url发起get请求
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != AppConstant.SUCCESS) {
                throw new RuntimeException("HttpResponseCode" + responseCode);
            } else {
                //按行读取结果
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                //返回JSONArray
                return (JSONArray) parse.parse(String.valueOf(informationString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 根据查询参数指定的url请求，返回JSON对象
     *
     * @param query 查询参数
     * @return JSON对象
     */
    public JSONObject getJsonObject(String query) {
        try {
            URL url = new URL(urlString + query);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != AppConstant.SUCCESS) {
                throw new RuntimeException("HttpResponseCode: " +
                        responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                return (JSONObject)
                        parse.parse(String.valueOf(informationString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}