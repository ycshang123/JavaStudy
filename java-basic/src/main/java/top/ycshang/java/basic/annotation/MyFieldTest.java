package top.ycshang.java.basic.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @program: java-basic
 * @description:通过反射获取注释
 * @author: ycshang
 * @create: 2021-10-10 23:21
 **/
@Slf4j
public class MyFieldTest {
    private static MyField annotation;
    /**
     * 使用自定义注解
     */
    @MyField(description = "学习之路", length = 12)
    private String username;

    public static void main(String[] args) {
        //获取类的模板
        Class<MyFieldTest> c = MyFieldTest.class;

        //获取所有字段
        for (Field f : c.getDeclaredFields()) {
            //判断这个字段是否有MyField注释
            if (f.isAnnotationPresent(MyField.class)) {
                MyField annotation = f.getAnnotation(MyField.class);
                log.info("字段:{},描述:{},长度:{}", f.getName(), annotation.description(), annotation.length());
            }
        }

    }
}