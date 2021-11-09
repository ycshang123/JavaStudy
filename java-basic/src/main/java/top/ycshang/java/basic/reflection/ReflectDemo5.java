package top.ycshang.java.basic.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-09 22:43
 **/
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("Class.txt"));

        String classname = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class<?> clazz = Class.forName(classname);
        Method method = clazz.getMethod(methodName);
        method.invoke(clazz.getDeclaredConstructor().newInstance());
    }
}