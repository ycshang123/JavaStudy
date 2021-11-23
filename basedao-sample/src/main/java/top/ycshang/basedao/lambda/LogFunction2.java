package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:41
 **/
@FunctionalInterface
public interface LogFunction2<T extends Pupil> {
    /**
     * 带泛型的方法型函数
     *
     * @param t 泛型
     */
    void log(T t);
}