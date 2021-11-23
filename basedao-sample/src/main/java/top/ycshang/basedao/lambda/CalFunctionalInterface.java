package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:36
 **/
@FunctionalInterface
public interface CalFunctionalInterface<T, R> {
    /**
     * 计算
     *
     * @param t1 入参1
     * @param t2 入参2
     * @return R
     */
    R cal(T t1, T t2);
}