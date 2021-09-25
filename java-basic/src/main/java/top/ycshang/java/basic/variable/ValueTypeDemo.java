package top.ycshang.java.basic.variable;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-09-25 21:26
 **/
@Slf4j
public class ValueTypeDemo {
    public static void demo1() {
        //浮点型
        float f = 30.0f;
        //强制类型转换
        int x = (int) f;
        log.info("x={}", x);
        //执行强制转换
        log.info("10/3={}", ((float) 10 / 3));
    }

    public static void demo2() {
        int max = Integer.MAX_VALUE;
        log.info("整型的最大值:{}", max);
        log.info("整型的最大值+1:{}", (max + 1));
        log.info("整型的最大值+2:{}", (max + 2));
        log.info("整型的最大值+2:{}", ((float) max + 2));
    }

    public static void demo3() {
        //字符是使用"'"括起来的数据
        char ch1 = 'a';
        //通过数字定义字符变量
        char ch2 = 97;
        log.info("ch1={}", ch1);
        log.info("ch2={}", ch2);
    }

    public static void demo4() {
        //表示的是一个"
        char ch1 = '\"';
        //表示的是一个、
        char ch2 = '\\';
        log.info("ch1={}", ch1);
        log.info("ch2={}", ch2);
        log.info("\"Hello World!\"");
    }

    public static void demo5() {
        //定义一个浮点型变量
        float num = 3.0f;
        log.info("两个小数相乘:{}", num * num);
    }

    public static void demo6() {
        //定义布尔型变量
        boolean flag = true;
        //打印输出
        log.info("浮点类型的flag={}", flag);
    }


    public static void demo7() {
        //定义整型变量
        int x = 30;
        //定义浮点型变量
        float y = 22.19f;
        log.info("x=30,y=22.19f;x/y={}", (x / y));
        log.info("10/3.5={}", (10 / 3.5));
        log.info("10/3={}", (10 / 3));
    }

    public static void  demo8(){
        //定义字符串变量
        String str ="Super Man";
        int x =80;
        //修改str的内容并将内容重新给str变量
        str = str+x;
        log.info("str={}",str);
    }

    public static void demo9(){
        //定义整型变量
        int  i=1;
        log.info("i+2={}",i+2);
        //定义整型变量
        int j=2;
        log.info("j+2={}",j+2);
    }

    public static void main(String[] args) throws  Exception{
        for(int i=1;i<10;i++){
            Method method = ValueTypeDemo.class.getMethod("demo"+i);
            method.invoke(null);
        }

    }
}
