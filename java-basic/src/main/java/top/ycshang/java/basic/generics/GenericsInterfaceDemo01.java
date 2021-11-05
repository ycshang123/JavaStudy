package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description: 泛型接口:实现接口的子类不明确声明类型
 * @author: ycshang
 * @create: 2021-11-05 23:58
 **/
public class GenericsInterfaceDemo01 implements Content<Integer> {
    private final int text;

    public GenericsInterfaceDemo01(int text) {
        this.text = text;
    }

    public static void main(String[] args) {
        GenericsInterfaceDemo01 demo = new GenericsInterfaceDemo01(10);
        System.out.print(demo.text());
    }

    @Override
    public Integer text() {
        return text;
    }
}
