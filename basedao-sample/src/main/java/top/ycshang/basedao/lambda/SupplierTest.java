package top.ycshang.basedao.lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:49
 **/
public class SupplierTest {
    public static void main(String[] args) {
        ArrayList<Integer> res = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(res);
    }

    public static ArrayList<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer e = sup.get();
            list.add(e);
        }
        return list;
    }
}