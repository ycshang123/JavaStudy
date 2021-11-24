package top.ycshang.basedao.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 22:23
 **/
public class ListTest {
    static List<String> list = new ArrayList<>(Arrays.asList("11", "22", "33", "44", "55", "66"));

    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
        test04();
        test05();
        test06();
        test07();
    }

    private static void test01() {
        for (int i = 0; i < list.size(); i++) {
            if (i == 1 || i == 2) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    private static void test02() {
        for (String str : list) {
            if ("22".equals(str) || "33".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }
    private static void test03() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if ("22".equals(str) || "33".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println("iterator遍历remove：" + list);
    }

    private static void test04() {
        list.removeIf(str -> "22".equals(str) || "33".equals(str));
        System.out.println("removeIf遍历remove：" + list);
    }

    private static void test05() {
        list = list.stream().filter(str -> !"22".equals(str) && !"33".equals(str)).collect(Collectors.toList());
        System.out.println("stream遍历remove:" + list);
    }

    private static void test06() {
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 1 || i == 2) {

            } else {
                retList.add(list.get(i));
            }
        }
        System.out.println("复制：" + retList);
    }


    private static void test07() {
        System.out.println("原始list：" + list);
        for (int i = list.size() - 1; i >= 0; i--) {
            String current = list.get(i);
            String next = "";
            if (current.contains("cc")) {
                if (i + 1 < list.size()) {
                    next = list.get(i + 1);
                    if (current.replace("cc", "").equals(next)) {
                        list.remove(current);
                    }
                }
            }
        }
        System.out.println("使用倒序遍历方式remove：" + list);
    }
}