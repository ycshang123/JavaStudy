package top.ycshang.java.basic.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @program: java-basic
 * @description: 无界通配符
 * @author: ycshang
 * @create: 2021-11-06 00:16
 **/
public class GenericsUnboundedWildcardDemo {
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }
}