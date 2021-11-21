package top.ycshang.basedao.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:52
 **/
public class PredicateTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "Java", "lambda", "www", "ok", "Web");
        List<String> ret = filterStr(list, (str) -> str.length() > 2);
        System.out.println(ret);
    }

    public static List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}