package top.ycshang.java.basic.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @description: 自定义注解
 * @author: ycshang
 * @create: 2021-10-11 01:07
 **/
@Slf4j
public class MyFieldTest {
    private static MyField annotation;

    @MyField(description = "学习之路",length = 12)
    private String username;

    public static void main(String[] args) {
        //获取类模板
        Class<MyFieldTest> c = MyFieldTest.class;

        for(Field f: c.getDeclaredFields()) {
            //判断这个字段是否右MyField注解
            if(f.isAnnotationPresent(MyField.class)) {
                MyField annotation = f.getAnnotation(MyField.class);
                log.info("字段:{},描述:{},长度:{}",f.getName(),annotation.description(),annotation.length());
            }
        }
    }
}
