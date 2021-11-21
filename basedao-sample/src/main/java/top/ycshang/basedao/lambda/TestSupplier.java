package top.ycshang.basedao.lambda;

import java.util.function.Supplier;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 22:02
 **/
public class TestSupplier {
    TestSupplier() {
        System.out.println("调用构造方法");
    }

    public static void main(String[] args) {
        test01();
        ////创建Supplier容器，声明为TestSupplier类型，此时并不会调用对象的构造方法，即不会创建对象
        //Supplier<TestSupplier> sup = TestSupplier::new;
        //sup.get().test();
        //System.out.println("------------");
        ////调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        //sup.get();
        ////每次get都会调用构造方法，即获取的对象不同
        //System.out.println(("是否是相同的对象实例" + sup.get()).equals(sup.get().toString()));
    }

    public void test() {
        System.out.println("Java8新特性，Supplier");
    }

    private static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    private static void test01() {
        Integer[] arr = {10, 2, 5, 3, 9, 4};
        int max2 = getMax(() -> {
            int max = 0;
            for (Integer i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(max2);
    }

}