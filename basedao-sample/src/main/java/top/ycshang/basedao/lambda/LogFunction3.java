package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:43
 **/
@FunctionalInterface
public interface LogFunction3<T extends Pupil, R extends PupilTeacher> {
    /**
     * 带多个泛型的功能型函数
     *
     * @param t t
     * @return R
     */
    R build(T t);
}