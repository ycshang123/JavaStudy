package top.ycshang.basedao.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:54
 **/
public class LambdaUsage {
    public static void main(String[] args) {
        collectionTraverse();
        useMap();
        useMapReduce();
        useFilter();
        testPredicate();
    }

    /**
     * 集合遍历
     */
    private static void collectionTraverse() {
        List<String> list = Arrays.asList("java", "c#", "javascript");
        //before java8
        for (String str : list) {
            System.out.println("before java8," + str);
        }
        //after java8
        list.forEach(x -> System.out.println("after java8," + x));
    }

    /**
     * 用lambda表达式实现map
     */
    private static void useMap() {
        List<Double> list = Arrays.asList(10.0, 20.0, 30.0);
        list.stream().map(x -> x + x * 0.05).forEach(System.out::println);
    }

    /**
     * 用lambda表达式实现map与reduce
     */
    private static void useMapReduce() {
        //before java8
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        double sum = 0;
        for (double each : cost) {
            each += each * 0.05;
            sum += each;
        }
        System.out.println("before java8," + sum);
        //after java8
        List<Double> list = Arrays.asList(10.0, 20.0, 30.0);
        double sum2 = list.stream().map(x -> x + x * 0.05).reduce(Double::sum).get();
        System.out.println("after java8," + sum2);
    }

    /**
     * Filter操作
     */
    private static void useFilter() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(System.out::println);
    }

    /**
     * 与函数式接口Predicate配合
     *
     * @param list      入参
     * @param condition 判断条件
     */
    private static void usePredicate(List<String> list, Predicate<String> condition) {
        list.stream().filter(condition).forEach(x -> System.out.println(x + " "));
    }

    /**
     * 测试usePredicate()
     */
    private static void testPredicate() {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        usePredicate(languages, x -> x.startsWith("J"));
        usePredicate(languages, x -> x.endsWith("a"));
        usePredicate(languages, x -> true);
        usePredicate(languages, x -> false);
        usePredicate(languages, x -> x.length() > 4);
    }
}