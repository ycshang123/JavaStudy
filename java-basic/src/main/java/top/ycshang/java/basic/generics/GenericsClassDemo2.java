package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description: 多个类型参数的泛型类
 * @author: ycshang
 * @create: 2021-11-05 23:52
 **/
public class GenericsClassDemo2 {
    public static void main(String[] args) {
        MyMap<Integer,String > map = new MyMap<>(1,"one");
        System.out.println(map);
    }
}