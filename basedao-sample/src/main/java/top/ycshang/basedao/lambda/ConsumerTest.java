package top.ycshang.basedao.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:47
 **/
public class ConsumerTest {
    public static void main(String[] args) {
        //consumerTest();
        //testConsumer();
        testConsumer2();
    }

    /**
     * 有一个参数，并且无返回值
     */
    public static void consumerTest() {
        //这个e就代表所实现的接口的方法的参数，
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式方式，" + e);
        consumer.accept("传入参数");
    }

    private static void testConsumer() {
        String[] arr = {"张三:18", "李四:25", "王五:28"};
        test1(arr, con -> {
            System.out.print("姓名：" + con.split(":")[0] + "，");
        }, con -> {
            System.out.println("年龄：" + con.split(":")[1]);
        });
    }

    private static void test1(String[] arr, Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String s : arr) {
            consumer1.andThen(consumer2).accept(s);
        }
    }
    private static void testConsumer2() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Effective Java", 110));
        list.add(new Book("Effective C++", 88));
        list.add(new Book("Effective C#", 59));
        list.forEach(x -> {
            if (x.getBookName().contains("Java")) {
                x.setBookPrice(x.getBookPrice() / 2);
            }
        });
        list.forEach(System.out::println);
    }

}