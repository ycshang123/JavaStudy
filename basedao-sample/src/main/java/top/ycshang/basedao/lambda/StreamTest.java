package top.ycshang.basedao.lambda;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:01
 **/
public class StreamTest {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        streamUsage();
        filter01();
        customFilter();
        getMaxLengthItem();
        getMaxInteger();
        getMaxAge();
        getGreaterThan();
        toUpperCase();
        integerItemPlus();
        addSalary();
        mergeStrArr();
        mergeNewArr();
        reduceOperator();
        salaryOperator();
        collectorsTest();
        partitionGroupTest();
        joiningTest();
        sortedTest();
        otherOperator();
        readFile();
        reduceListTest();
    }

    /**
     * 遍历/匹配（foreach/find/match）
     */
    private static void streamUsage() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    /**
     * 初始化
     */
    private static void initData() {
        employeeList.add(new Employee("ZhangSan", 25, 3000, "male", "nanjing"));
        employeeList.add(new Employee("LiSi", 27, 8500, "male", "wuxi"));
        employeeList.add(new Employee("WangWu", 29, 7000, "female", "nanjing"));
        employeeList.add(new Employee("ZhaoLiu", 26, 3000, "female", "wuxi"));
        employeeList.add(new Employee("YangQi", 27, 5000, "male", "wuxi"));
        employeeList.add(new Employee("XuBa", 21, 7000, "female", "nanjing"));
    }
    /**
     * 筛选员工中未满18周岁的人，并形成新的集合
     */
    private static void filter01() {
        initData();
        List<Employee> collect = employeeList.stream().filter(x -> x.getAge() > 18).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 自定义条件匹配
     */
    private static void customFilter() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(8);
        map.put("id", 1);
        map.put("name", "ZhangSan");
        map.put("age", 18);
        list.add(map);

        Map<String, Object> map2 = new HashMap<>(8);
        map2.put("id", 2);
        map2.put("name", "LiSi");
        map2.put("age", 20);
        list.add(map2);

        System.out.println("初始化：" + list);
        java8Stream(list);
        beforeJava8(list);

    }

    /**
     * Java8 Stream方式
     *
     * @param list list
     */
    private static void java8Stream(List<Map<String, Object>> list) {
        List<Map<String, Object>> collect = list.stream().filter(a -> "ZhangSan".equals(a.get("name").toString())).collect(Collectors.toList());
        System.out.println("in Java8 Stream:" + collect);
    }

    /**
     * Java8之前方式
     *
     * @param list list
     */
    private static void beforeJava8(List<Map<String, Object>> list) {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> hashMap = new HashMap<>();
        for (Map<String, Object> map : list) {
            if ("ZhangSan".equals(map.get("name"))) {
                hashMap.putAll(map);
            }
        }
        result.add(hashMap);
        System.out.println("before Java8:" + result);
    }

    /**
     * 获取String集合中最长的元素
     */
    private static void getMaxLengthItem() {
        List<String> list = Arrays.asList("ZhangSan", "LiSi", "WangWu", "ZhaoLiu");
        Comparator<? super String> comparator = Comparator.comparing(String::length);
        Optional<String> max = list.stream().max(comparator);
        System.out.println(max);
    }

    /**
     * 获取Integer集合中的最大值
     */
    private static void getMaxInteger() {
        List<Integer> list = Arrays.asList(1, 17, 27, 7);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(max2);
    }

    /**
     * 获取员工中年龄最大的人
     */
    private static void getMaxAge() {
        initData();
        Comparator<? super Employee> comparator = Comparator.comparingInt(Employee::getAge);
        Optional<Employee> max = employeeList.stream().max(comparator);
        System.out.println(max);
    }
    /**
     * 计算integer集合中大于10的元素的个数
     */
    private static void getGreaterThan() {
        List<Integer> list = Arrays.asList(1, 27, 27, 7);
        long count = list.stream().filter(x -> x > 10).count();
        System.out.println(count);
    }

    /**
     * 字符串大写
     */
    private static void toUpperCase() {
        List<String> list = Arrays.asList("ZhangSan", "LiSi", "WangWu", "ZhaoLiu");
        list.stream().forEach(t -> t.toUpperCase());
        List<String> collect = list.stream().map(t -> t.toUpperCase()).collect(Collectors.toList());
        List<String> collect2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);
    }

    /**
     * 整数数组每个元素+3
     */
    private static void integerItemPlus() {
        List<Integer> list = Arrays.asList(1, 17, 27, 7);
        List<Integer> collect = list.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 公司效益好，每人涨2000
     */
    private static void addSalary() {
        initData();
        List<Employee> collect = employeeList.stream().map(x -> {
            x.setAge(x.getSalary() + 2000);
            return x;
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 将两个字符数组合并成一个新的字符数组
     */
    private static void mergeStrArr() {
        String[] arr = {"z, h, a, n, g", "s, a, n"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        List<String> collect = list.stream().flatMap(x -> {
            String[] array = x.split(",");
            return Arrays.stream(array);
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 将两个字符数组合并成一个新的字符数组
     */
    private static void mergeNewArr() {
        String[] arr = {"z, h, a, n, g", "s, a, n"};
        List<String> list = Arrays.asList(arr);
        List<String> collect = list.stream().flatMap(x -> {
            String[] array = x.split(",");
            return Arrays.stream(array);
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * reduce 求Integer集合的元素之和、乘积和最大值
     */
    private static void reduceOperator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //求和
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println("求和:" + reduce);
        //求积
        Optional<Integer> reduce2 = list.stream().reduce((x, y) -> x * y);
        System.out.println("求积:" + reduce2);
        //求最大值
        Optional<Integer> reduce3 = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println("求最大值:" + reduce3);
    }

    /**
     * 求所有员工的工资之和和最高工资
     */
    private static void salaryOperator() {
        initData();
        Optional<Integer> reduce = employeeList.stream().map(Employee::getSalary).reduce(Integer::sum);
        Optional<Integer> reduce2 = employeeList.stream().map(Employee::getSalary).reduce(Integer::max);
        System.out.println("工资之和:" + reduce);
        System.out.println("最高工资:" + reduce2);
    }
    /**
     * 取出大于18岁的员工转为map
     */
    private static void list2Map() {
        initData();
        Map<String, Employee> collect = employeeList.stream().filter(x -> x.getAge() > 18).collect(Collectors.toMap(Employee::getName, y -> y));
        System.out.println(collect);
    }

    /**
     * 统计员工人数、平均工资、工资总额、最高工资
     */
    private static void collectorsTest() {
        //统计员工人数
        long count = employeeList.stream().collect(Collectors.counting());
        //求平均工资
        double average = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        //求最高工资
        Optional<Integer> max = employeeList.stream().map(Employee::getSalary).collect(Collectors.maxBy(Integer::compare));
        //求工资之和
        int sum = employeeList.stream().collect(Collectors.summingInt(Employee::getSalary));
        //一次性统计所有信息
        DoubleSummaryStatistics collect = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("统计员工人数:" + count);
        System.out.println("求平均工资:" + average);
        System.out.println("求最高工资:" + max);
        System.out.println("求工资之和:" + sum);
        System.out.println("一次性统计所有信息:" + collect);
    }

    /**
     * 将员工按性别和地区分组
     */
    private static void partitionGroupTest() {
        initData();
        // 将员工按薪资是否高于6000分组
        Map<Boolean, List<Employee>> part = employeeList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 6000));
        // 将员工按性别分组
        Map<String, List<Employee>> group = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Employee>>> group2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(Employee::getAddress)));
        System.out.println("员工按薪资是否大于6000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);
    }

    /**
     * joining结合测试
     */
    private static void joiningTest() {
        initData();
        String names = employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(names);
    }

    /**
     * sorted排序测试
     */
    private static void sortedTest() {
        initData();
        // 按工资升序排序（自然排序）
        List<String> newList = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).map(Employee::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getAge)).map(Employee::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = employeeList.stream().sorted((p1, p2) -> {
            if (Objects.equals(p1.getSalary(), p2.getSalary())) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Employee::getName).collect(Collectors.toList());
        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);
    }

    /**
     * 流的合并、去重、限制、跳过等操作
     */
    private static void otherOperator() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }
    /**
     * 读取文件的流操作
     */
    private static void readFile() {
        String fileName = "test.txt";
        Path path = new File(fileName).toPath();
        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("readFile error," + e.getMessage());
        }
    }
    /**
     * 计算两个list中的差集
     */
    private static void reduceListTest() {
        List<String> list1 = new ArrayList<>(Arrays.asList("aaa", "bba", "ccc"));
        List<String> list2 = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc"));
        List<String> reduceList = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println(reduceList);
    }

}