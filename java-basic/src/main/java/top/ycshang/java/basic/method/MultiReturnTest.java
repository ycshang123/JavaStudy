package top.ycshang.java.basic.method;

import io.vavr.Tuple;
import io.vavr.Tuple3;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * @program: java-basic
 * @description:方法返回个结果 用可变长参数传入多个整数，同时返回最大值和最小值、求和等结果
 * @author: ycshang
 * @create: 2021-10-14
 **/
@Slf4j
public class MultiReturnTest {
    public static void main(String[] args) {
        int[] resultArr = multiReturnMethod1(4, 5, 9);
        log.info(Arrays.toString(resultArr));
        log.info("================================");
        Map<String, Integer> resultMap = multiReturnMethod2(4, 5, 9);
        log.info(String.valueOf(resultMap));
        log.info("================================");
        ReturnObject resultObject = multiReturnMethod3(4, 5, 9);
        log.info(resultObject.toString());
        log.info("================================");
        Tuple tuple = multiReturnMethod4(4, 5, 9);
        log.info(String.valueOf(tuple));
        log.info("================================");
        Triplet<Integer, Integer, Integer> triplet = multiReturnMethod5(4, 5, 9);
        log.info(String.valueOf(triplet));

    }

    /**
     * 可变长参数+整型数组返回
     *
     * @param args
     * @return
     */
    public static int[] multiReturnMethod1(int... args) {
        int[] arr = new int[3];
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        arr[0] = max.getAsInt();
        arr[1] = min.getAsInt();
        arr[2] = sum;
        return arr;
    }

    /**
     * 可变长参数
     *
     * @param args
     * @return
     */
    public static Map<String, Integer> multiReturnMethod2(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        //初始化集合最好指定大小
        Map<String, Integer> map = new HashMap<>(4);
        map.put("max", max.getAsInt());
        map.put("min", min.getAsInt());
        map.put("sum", sum);
        return map;
    }

    /**
     * 可变长参数
     * 封装的结果对象
     *
     * @param args
     * @return
     */

    public static ReturnObject multiReturnMethod3(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return new ReturnObject(max.getAsInt(), min.getAsInt(), sum);

    }

    /**
     * 可变长参数
     *
     * @param args
     * @return Tuple3
     */
    public static Tuple3<Integer, Integer, Integer> multiReturnMethod4(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return Tuple.of(max.getAsInt(), min.getAsInt(), sum);
    }

    /**
     * 可变长参数
     *
     * @param args
     * @return Triplet
     */
    public static Triplet<Integer, Integer, Integer> multiReturnMethod5(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return new Triplet<Integer, Integer, Integer>(max.getAsInt(), min.getAsInt(), sum);
    }


}