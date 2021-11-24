package top.ycshang.basedao.list;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 22:18
 **/
public class MapSample {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};
        Map<String, Integer> map = new HashMap<>(8);
        for (int i = 0, n = array.length; i < n; i++) {
            String key = array[i];
            int frequency = i + 1;
            map.put(key, frequency);
        }
        System.out.println(map);
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap);
        //hashmap的同步
        Map<String, Integer> map1 = Collections.synchronizedMap(map);
        System.out.println(map1);
    }
}