package top.ycshang.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description: 三目运算示例
 * @author: ycshang
 * @create: 2021-09-28 21:07
 **/
@Slf4j
public class ConditionalOperatorDemo {
    public static void main(String[] args) {
        int a, b;
        a = 10;
        b = (a == 1) ? 20 : 30;
        log.info("Value of b is:" + b);
        b = (a == 10) ? 20 : 30;
        log.info("Value of b is:" + b);
    }
}