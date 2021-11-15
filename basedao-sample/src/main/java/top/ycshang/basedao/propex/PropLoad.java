package top.ycshang.basedao.propex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-15 10:42
 **/
public class PropLoad {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //    使用IO读取外部属性文件
        InputStream in = PropLoad.class.getResourceAsStream("/database.properties");
        properties.load(in);
        //    所有的键存储到Set集合
        Set<String> keySet = properties.stringPropertyNames();
        //    遍历keySet,获取对应的值
        for (String key : keySet) {
            System.out.println(key + ":" + properties.getProperty(key));
        }
    }
}