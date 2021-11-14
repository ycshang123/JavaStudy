package top.ycshang.java.basic.annotation;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 20:57
 **/
@FunctionalInterface
public interface GreetingService {
    /**
     * 抽象⽅法
     *
     * @param message ⼊参
     */
    void sayMessage(String message);
}