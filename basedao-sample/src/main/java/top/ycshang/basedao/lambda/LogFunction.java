package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:39
 **/
@FunctionalInterface
public interface LogFunction {
    /**
     * 打log日志
     */
    void log();
}