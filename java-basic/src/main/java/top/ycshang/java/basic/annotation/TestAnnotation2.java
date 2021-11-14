package top.ycshang.java.basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 21:02
 **/
@TestAnnotation(id = 111, msg = "hello")
public class TestAnnotation2 {
    @Check(value = "hi")
    int a;
    @Perform
    public void testMethod() {
    }
    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
    public static void main(String[] args) {
        boolean hasAnnotation =
                TestAnnotation2.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation =
                    TestAnnotation2.class.getAnnotation(TestAnnotation.class);
            //获取类的注解
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
        try {
            Field a = TestAnnotation2.class.getDeclaredField("a");
            a.setAccessible(true);
            //获取⼀个成员变量上的注解
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value:" + check.value());
            }
            Method testMethod =
                    TestAnnotation2.class.getDeclaredMethod("testMethod");
            if (testMethod != null) {
                // 获取⽅法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for (Annotation an : ans) {
                    System.out.println("method testMethod annotation:" +
                            an.annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException | SecurityException |
                NoSuchMethodException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }
}
