package top.ycshang.basedao.context;

/**
 * @program: basedao-sample
 * @description:使用ThreadLocal封装传递全局存储数据
 * @author: ycshang
 * @create: 2021-11-14 22:19
 **/
public class DataContext implements AutoCloseable {
    public static final ThreadLocal<Object> CTX = new ThreadLocal<>();

    public static Object getData() {
        return CTX.get();
    }

    public static void setData(Object data) {
        CTX.set(data);
    }

    @Override
    public void close() {

    }
}