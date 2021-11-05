package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description: 泛型类型的嵌套
 * @author: ycshang
 * @create: 2021-11-05 23:56
 **/
public class GenericsClassDemo03 {
    public static void main(String[] args) {
        Info<String> info = new Info("Hello");
        MyMap<Integer, Info<String>> map = new MyMap<>(1, info);
        System.out.println(map);
    }
}