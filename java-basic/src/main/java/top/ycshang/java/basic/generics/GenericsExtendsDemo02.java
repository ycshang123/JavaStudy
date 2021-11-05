package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-06 00:07
 **/
public class GenericsExtendsDemo02 {
    static class A { /* ... */ }
    interface B { /* ... */ }
    interface C { /* ... */ }
    static class D1 <T extends A & B & C> { /* ... */ }
    static class E extends A implements B, C { /* ... */ }
    public static void main(String[] args) {
        D1<E> demo1 = new D1<>();
        System.out.println(demo1.getClass().toString());
    }
}
