package top.ycshang.basedao.list;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 20:18
 **/
public class SetSample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Bernadine");
        set.add("Elizabeth");
        set.add("Gene");
        set.add("Elizabeth");
        set.add("Clara");
        System.out.println(set);

        Set<String> sortedSet = new TreeSet<>(set);
        System.out.println(sortedSet);
    }
}