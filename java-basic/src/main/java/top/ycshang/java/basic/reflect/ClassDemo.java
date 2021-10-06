package top.ycshang.java.basic.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description: Java反射之Class练习
 * 在面向对象的语言里，万事万物皆对象，
 * 类的类型是Class
 * 反射机制，想要获取一个类或者调用某个类的方法，首先要获取该类的Class对象
 * @author: ycshang
 * @create: 2021-10-06 20:28
 **/

@Slf4j
public class ClassDemo {

    public static void main(String[] args) {
        //在Java API中，提供了获取Class类对象的三种方法

        //第一种  使用Class.forName 静态方法{已明确类的全路径}

        Class clazz1 = null;

        try {
            clazz1 = Class.forName("top.ycshang.java.basic.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //第二种  .class 方法{仅适合在编译欠就已经明确要操作的Class}
        Class clazz2 = User.class;


        //第三种，使用类对象的getClass()方法，适合有对象示例的情况下
        User user = new User();
        Class clazz3 = user.getClass();


        //结果
        log.info("clazz1——clazz2——clazz3:{},{},{}", clazz1, clazz2, clazz3);
        log.info(String.valueOf(clazz1 == clazz2));
        log.info(String.valueOf(clazz3 == clazz2));
    }
}