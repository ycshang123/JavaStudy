package top.ycshang.java.basic.annotation;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 20:44
 **/
public class SafeVarargsAnnotation<S> {
    private S[] args;
    public SafeVarargsAnnotation(S... args){
        this.args = args;
    }
    /**
     * @description: 使⽤⼀下record
     * @author: mqxu
     * @date: 2021-11-10
     **/
//    public record SafeVarargsAnnotation<S>(S...args) {

//    /**
//     * 构造⽅法可以使⽤@SafeVarargs标记
//     *
//     * @param args ⼊参数组
//     */
//    @SafeVarargs
//    public SafeVarargsAnnotation {
//    }

    /**
     * 此处不能使⽤@SafeVarargs，因为此⽅法未声明为static或final⽅法，
     * 如果要抑制unchecked警告，可以使⽤@SuppressWarnings注解
     *
     * @param args ⼊参数组
     */
    @SuppressWarnings("unchecked")
    public void loopPrintArgs(S... args) {
        for (S arg : args) {
            System.out.println(arg);
        }
    }

    /**
     * final⽅法可以使⽤@SafeVarargs标记
     *
     * @param args ⼊参数组
     */
    @SafeVarargs
    public final void printSelfArgs(S... args) {
        for (S arg : this.args) {
            System.out.println(arg);
        }
    }

    /**
     * static⽅法可以使⽤@SafeVarargs标记
     *
     * @param infos ⼊参泛型数组
     * @param <T>   泛型⽅法
     */
    @SafeVarargs
    public static <T> void loopPrintInfo(T... infos) {
        for (T info : infos) {
            System.out.println(info);
        }
    }

    public static void main(String[] args) {
        SafeVarargsAnnotation.loopPrintInfo("A", "B", "C");
    }

}
