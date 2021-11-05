package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description: 单类型参数的泛型类
 * @author: ycshang
 * @create: 2021-11-05 23:47
 **/
public class GenericsClassDemo01 {
    public static void main(String[] args) {
        Info<Integer> info = new Info<>();
        info.setValue(10);
        System.out.println(info.getValue());
        Info<String> info2 = new Info<>();
        info2.setValue("xxx");
        System.out.println(info2.getValue());
    }
}