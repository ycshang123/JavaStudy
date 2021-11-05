package top.ycshang.java.basic.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-06 00:14
 **/
public class GenericsLowerBoundedWildcardDemo {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addNumbers(list);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}