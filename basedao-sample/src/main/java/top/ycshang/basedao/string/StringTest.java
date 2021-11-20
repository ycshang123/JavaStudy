package top.ycshang.basedao.string;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 00:32
 **/
public class StringTest {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    private static void test01() {
        //int a =0;
        //String b = String.valueOf(a);
        //System.out.println(b);
        Object a = 0;
        if (a instanceof String) {
            String b = (String) a;
            System.out.println(b);
        } else {
            System.out.println("error");
        }
    }


    private static void test02() {
        Integer a = 0;
        String b = a.toString();
        System.out.println(b);
    }


    private static void test03() {
        Integer a = null;
        String b = String.valueOf(a);
        System.out.println(b);
        System.out.println(b == null);
        System.out.println(b.equals("null"));
    }
}