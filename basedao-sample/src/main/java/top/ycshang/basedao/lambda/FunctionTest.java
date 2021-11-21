package top.ycshang.basedao.lambda;

import java.util.function.Function;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:51
 **/
public class FunctionTest {
    public static void main(String[] args) {
        String newStr = strHandler("abc", (str) -> str.toUpperCase());
        System.out.println(newStr);
        newStr = strHandler("  abc  ", (str) -> str.trim());
        System.out.println(newStr);
    }

    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}