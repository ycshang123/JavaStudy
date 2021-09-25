package top.ycshang.java.basic.variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description:变量demo
 * @author: ycshang
 * @create: 2021-09-25 20:58
 **/
@Slf4j
public class VariableDemo {
    /**
     * 类变量(静态变量)
     */
    private static  int staticVar =1024;
    /**
     * 实例变量
     */
    private String instanceVar ="hello";

    /**
     * 实例方法
     */
    public void method(){
        //局部变量
        int localVar =666;
        log.info("localVar before:{}",localVar);
        localVar =888;
        log.info("localVar after:{}",localVar);
    }

    public static void main(String[] args) {
        //访问类变量(静态变量),无需实例化对象
        log.info("staticVar before:{}",staticVar);
        staticVar = 2048;
        log.info("staticVar after:{}",staticVar);
        //创建实例对象，访问实例变量
        VariableDemo vd = new VariableDemo();
        log.info("staticVar before:{}",vd.instanceVar);
        vd.instanceVar ="world";
        log.info("staticVar after:{}",vd.instanceVar);
        //调用实例方法
        vd.method();
    }


}