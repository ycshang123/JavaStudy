package top.ycshang.basedao.annotation;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 00:21
 **/
public class MyTestTarget {
    @MyTest
    public void test01(){
        System.out.println("test01");
    }

    public void test02(){
        System.out.println("test02");
    }
    @MyTest
    public void test03(){
        System.out.println("test03");
    }
}