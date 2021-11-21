package top.ycshang.basedao.lambda;

import java.util.Comparator;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:53
 **/
public class MethodTest {
    public static void main(String[] args) {
        methodRef();
    }

    public static void methodRef() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        //等价于下面的写法（方法引用）
        Comparator<Integer> comparator1 = Integer::compare;
        int compare = comparator.compare(1, 2);
        int compare1 = comparator1.compare(1, 2);
        System.out.println("compare:" + compare);
        System.out.println("compare1:" + compare1);
    }
}