package top.ycshang.basedao.annotation;

import java.lang.reflect.Method;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 00:24
 **/
public class CallMyTest {
    public static void main(String[] args) throws Exception {
        Class<?> c = MyTestTarget.class;
    //    获得所有成员方法
        Method[] methods = c.getMethods();
    //    创建MyTestDemo类对象
        Object obj = c.getDeclaredConstructor().newInstance();
    //    遍历方法数组
        for(Method m:methods){
        //    判断方法 m上是否使用注解Mytest
            if(m.isAnnotationPresent(MyTest.class)){
                m.invoke(obj);
            }
        }

    }
}