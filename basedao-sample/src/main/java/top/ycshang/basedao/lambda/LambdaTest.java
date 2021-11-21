package top.ycshang.basedao.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:37
 **/
public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通线程启动");
            }
        };
        //runnable.run();
        //test1();
        //test2();
        //test3();
        test4();
    }

    /**
     * 无参数，无返回值
     */
    public static void test1() {
        //“->”左边只有一个小括号，表示无参数，右边是Lambda体(就相当于实现了匿名内部类里面的方法了，(就是一个可用的接口实现类了))
        Runnable runnable = () -> System.out.println("Lambda表达式线程启动");
        runnable.run();
    }

    /**
     * 有一个参数，并且无返回值
     */
    public static void test2() {
        //这个e就代表所实现的接口的方法的参数，
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式方式，" + e);
        consumer.accept("传入参数");
    }

    /**
     * 有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
     */
    public static void test3() {
        //Lambda 体中有多条语句，记得要用大括号括起来
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        int compare = com.compare(100, 244);
        System.out.println("有两个以上的参数，有返回值," + compare);
    }


    /**
     * 若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
     */
    public static void test4() {
        System.out.println("若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写," + Integer.compare(100, 244));
    }
}