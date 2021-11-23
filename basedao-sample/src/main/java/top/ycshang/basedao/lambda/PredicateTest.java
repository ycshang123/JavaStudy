package top.ycshang.basedao.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:52
 **/
public class PredicateTest {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("hello", "Java", "lambda", "www", "ok", "Web");
        //List<String> ret = filterStr(list, (str) -> str.length() > 2);
        //System.out.println(ret);
        //predicateTest();
        //test1();
        //test2();
        //test3();
        test4();
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
    /**
     * 泛型方法
     * ?主要用于变量上，T主要用于类或方法上
     *
     * @param param 函数式接口入参
     * @param <T>   泛型入参
     * @return Predicate<T>
     */
    private static <T> Predicate<T> getDistinct(Function<? super T, ?> param) {
        Map<Object, Boolean> map = new HashMap<>(8);
        //hash中不存在这个key，则返回null，如果存在返回true
        return t -> map.putIfAbsent(param.apply(t), Boolean.TRUE) == null;
    }

    private static void predicateTest() {
        List<User> list = new ArrayList<>();
        list.add(new User("zs", 18));
        list.add(new User("ls", 28));
        list.add(new User("ww", 38));
        list.add(new User("zl", 40));
        System.out.println(list);
        System.out.println("----------------stream().filter-------------------------");
        List<User> userList = list.stream().filter(getDistinct(User::getName)).collect(Collectors.toList());
        System.out.println(userList);
    }


    /**
     * 利用函数式接口比较
     */
    private static void test1() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return "zs".equals(t);
            }
        };
        boolean test = predicate.test("ls");
        System.out.println(test);
        boolean test2 = predicate.test("zs");
        System.out.println(test2);
    }

    static Map<String, Object> hashMap = new HashMap<>();

    /**
     * 常见的比较
     */
    private static void test2() {
        boolean judgeLength = judgeLength("ZhangSan");
        System.out.println(judgeLength);
        boolean judgeInt = judgeInt(10);
        System.out.println(judgeInt);
        hashMap.put("zs", 18);
        hashMap.put("ls", 28);
        hashMap.put("ww", 38);
        boolean judgeKey = judgeKey("zs");
        System.out.println(judgeKey);
    }

    /**
     * 判断传入的字符串的长度是否大于5
     *
     * @param str 入参
     * @return boolean
     */
    private static boolean judgeLength(String str) {
        return str.length() > 5;
    }

    /**
     * 判断传入的数字是否大于0
     *
     * @param i 入参
     * @return boolean
     */
    private static boolean judgeInt(int i) {
        return i > 0;
    }

    /**
     * 判断传入的值在hash中是否存在
     *
     * @param key key
     * @return boolean
     */
    private static boolean judgeKey(String key) {
        return hashMap.containsKey(key);
    }

    /**
     * 调用Predicate写法
     */
    private static void test3() {
        boolean judgeByPredicate = judgeByPredicate("ZhangSan", t -> t.length() > 5);
        System.out.println(judgeByPredicate);

        boolean judgeByPredicate2 = judgeByPredicate(10, t -> t > 0);
        System.out.println(judgeByPredicate2);

        hashMap.put("zs", 18);
        hashMap.put("ls", 28);
        hashMap.put("ww", 38);

        boolean judgeByPredicate3 = judgeByPredicate("zs1", t -> hashMap.containsKey(t));
        System.out.println(judgeByPredicate3);
    }

    /**
     * Predicate写法，泛型方法
     *
     * @param t         泛型
     * @param predicate 断言函数式接口
     * @param <T>       泛型
     * @return boolean
     */
    private static <T> boolean judgeByPredicate(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    /**
     * And 、Or、取反测试
     */
    private static void test4() {
        boolean judgeByPredicate = judgeByPredicateAnd("ZhangSan", t -> t.length() > 5, t -> t.length() < 7);
        System.out.println("*and**" + judgeByPredicate);

        boolean judgeByPredicateOr = judgeByPredicateOr("ZhangSan", t -> t.length() > 5, t -> t.length() < 7);
        System.out.println("*or**" + judgeByPredicateOr);

        boolean judgeByPredicate4 = judgeByPredicateAnd2("ZhangSan", t -> t.length() > 5, t -> t.length() < 10, t -> t.contains("li"));
        System.out.println("***" + judgeByPredicate4);

        boolean judgeByPredicate2 = judgeByPredicate(10, t -> t > 0);
        System.out.println(judgeByPredicate2);

        hashMap.put("zs", 18);
        hashMap.put("ls", 28);
        hashMap.put("ww", 38);
        boolean judgeByPredicate3 = judgeByPredicate("zs1", t -> hashMap.containsKey(t));
        System.out.println(judgeByPredicate3);
    }

    private static void test05() {
        String str1 = "zhangsan";
        String str2 = "zs";
        String str3 = "zhangsan";
        boolean judgeByPredicateEquals = judgeByPredicateEquals(str1, str2);
        System.out.println("judgeByPredicateEquals1:" + judgeByPredicateEquals);
        judgeByPredicateEquals = judgeByPredicateEquals(str1, str3);
        System.out.println("judgeByPredicateEquals2:" + judgeByPredicateEquals);
    }


    /**
     * negate --> 取反 (逻辑非)
     *
     * @param t         泛型
     * @param predicate 函数式接口
     * @param <T>       泛型
     * @return boolean
     */
    private static <T> boolean judgeByPredicateNegate(T t, Predicate<T> predicate) {
        return predicate.negate().test(t);
    }

    /**
     * 理论上and可以无限加下去
     *
     * @param <T>        泛型
     * @param t          待判断的参数
     * @param predicate1 断定表达式1
     * @param predicate2 断定表达式2
     * @return 是否满足两个条件
     */
    private static <T> boolean judgeByPredicateAnd(T t, Predicate<T> predicate1, Predicate<T> predicate2) {
        return predicate1.and(predicate2).test(t);
    }

    /**
     * 逻辑与
     *
     * @param t          泛型
     * @param predicate1 断定表达式1
     * @param predicate2 断定表达式2
     * @param predicate3 断定表达式3
     * @param <T>        泛型
     * @return boolean
     */
    private static <T> boolean judgeByPredicateAnd2(T t, Predicate<T> predicate1, Predicate<T> predicate2, Predicate<T> predicate3) {
        return predicate1.and(predicate2).and(predicate3).test(t);
    }

    /**
     * 逻辑或
     *
     * @param t          泛型
     * @param predicate1 断定表达式1
     * @param predicate2 断定表达式2
     * @param <T>        泛型
     * @return boolean
     */
    private static <T> boolean judgeByPredicateOr(T t, Predicate<T> predicate1, Predicate<T> predicate2) {
        return predicate1.or(predicate2).test(t);
    }

    /**
     * 判等
     *
     * @param str1 入参
     * @param str2 入参
     * @return boolean
     */
    private static boolean judgeByPredicateEquals(String str1, String str2) {
        return Predicate.isEqual(str1).test(str2);
    }

}