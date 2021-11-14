package top.ycshang.java.basic.annotation;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 19:55
 **/
public @interface MyAnnotation {
    // 定义公共的final静态属性
    int age = 25;
    // 定义公共的抽象⽅法
    String name();
}
