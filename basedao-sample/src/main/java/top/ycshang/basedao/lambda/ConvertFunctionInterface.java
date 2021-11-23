package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:37
 **/
@FunctionalInterface
public interface ConvertFunctionInterface<T, R> {
    /**
     * 类型转换
     *
     * @param t t
     * @return R
     */
    R convert(T t);
}