package top.ycshang.java.basic;

import top.ycshang.java.basic.array.ArrayDemo;

/**
 * @program: java-basic
 * @description: App
 * @author: ycshang
 * @create: 2021-09-23 22:20
 **/
public class App {
    public static void main(String[] args) {
        System.out.println("app launch");
        int[] arr = {1, 2, 3, 4, 5};
        ArrayDemo ad = new ArrayDemo();
        int sum = ad.getSum(arr);
        System.out.println("sum=" + sum);
    }
}