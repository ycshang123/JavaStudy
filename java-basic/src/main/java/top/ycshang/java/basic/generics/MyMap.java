package top.ycshang.java.basic.generics;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-05 23:53
 **/
public class MyMap<K,V> {
    private final K key;
    private final V value;
    public MyMap(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return "MyMap{" + "key=" + key + ", value=" + value + '}';
    }
}