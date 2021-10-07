package top.ycshang.java.basic.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-07 19:47
 **/
@Slf4j
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //获取TargetObject类的Class对象
        Class<?> targetClass = Class.forName("top.ycshang.java.basic.reflect.TargetObject");
        //创建TargetObject类无参构造方法，创建实例
        TargetObject targetObject = (TargetObject) targetClass.getDeclaredConstructor().newInstance();


        //创建中TargetObject类中所有定义的非构造方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            log.info("all methods:{}", method.getName());
        }

        //获取publicMethod方法并调用(需要传String类型的参数)
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "Java");

        //获取指定参数value并进行修改，赋值为JavaStudy
        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改,取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "JavaStudy");


        //调用privateMethod方法(无参)，得到value的最新值
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

    }
}