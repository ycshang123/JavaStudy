package top.ycshang.java.basic.serizlize;

import java.io.Serializable;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-18 21:55
 **/
public class Singleton implements Serializable {

    private static final long serialVersionUID = -1576643344804979563L;

    private Singleton() {
    }

    public static synchronized Singleton getSingleton() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }
    private Object readResolve() {
        return SingletonHolder.singleton;
    }
}