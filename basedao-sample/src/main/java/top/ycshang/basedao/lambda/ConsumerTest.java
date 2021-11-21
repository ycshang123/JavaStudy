package top.ycshang.basedao.lambda;

import java.util.function.Consumer;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:47
 **/
public class ConsumerTest {
    public static void main(String[] args) {
        consumerTest();
    }

    /**
     * 有一个参数，并且无返回值
     */
    public static void consumerTest() {
        //这个e就代表所实现的接口的方法的参数，
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式方式，" + e);
        consumer.accept("传入参数");
    }
}