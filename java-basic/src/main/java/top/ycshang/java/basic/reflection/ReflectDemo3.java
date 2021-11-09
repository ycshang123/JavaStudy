package top.ycshang.java.basic.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-09 22:15
 **/
@Slf4j
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        Class<?> clazz = list.getClass();
        Method method = clazz.getMethod("add",Object.class);
        method.invoke(list,28);
        log.info("反射太强大了:{}",list);
    }
}