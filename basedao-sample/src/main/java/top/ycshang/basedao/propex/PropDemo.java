package top.ycshang.basedao.propex;

import java.util.Properties;
import java.util.Set;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-15 10:42
 **/
public class PropDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //存储键值对
        properties.setProperty("host", "localhost");
        properties.setProperty("port", "3306");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");
        properties.setProperty("password", "root12313");
        System.out.println(properties);
        //获取port键对应的值
        String value = properties.getProperty("port");
        System.out.println(value);
        //    所有的键存储到Set集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "==" + properties.getProperty(key));
        }
    }
}