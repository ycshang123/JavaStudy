package top.ycshang.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description:算数操作符示例
 * @author: ycshang
 * @create: 2021-09-28 20:32
 **/
@Slf4j
public class MathOperatorDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 25;
        int d = 25;
        log.info("a+b=" + (a + b));
        log.info("a-b=" + (a - b));
        log.info("a*b=" + (a * b));
        log.info("b/a=" + (b / a));
        log.info("b%a=" + (b % a));
        log.info("c%a=" + (c % a));
        log.info("a++=" + (a++));
        log.info("a--=" + (a--));
        log.info("d++=" + (d++));
        log.info("++d" + (++d));
    }
}