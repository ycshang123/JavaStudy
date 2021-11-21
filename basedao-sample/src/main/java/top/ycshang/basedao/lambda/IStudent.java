package top.ycshang.basedao.lambda;
@FunctionalInterface
public interface IStudent {
    /**
     * study方法
     *
     * @param technology 入参
     * @param time       入参
     */
    void study(String technology, int time);
}
