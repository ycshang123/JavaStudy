package top.ycshang.basedao.list;

import java.util.*;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 00:12
 **/
public class ListNestMap {
    public static void main(String[] args) {
        //List大集合
        List<Map<String, String>> bigList = new ArrayList<>();
        //Map存储学生信息小集合
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        //存储学生信息
        map1.put("001", "张三");
        map1.put("002", "李四");

        map2.put("001", "黄晓明");
        map2.put("002", "黄晓华");
        map2.put("003", "黄晓杰");
        map2.put("004", "黄晓力");

        //map存储到List集合
        bigList.add(map1);
        bigList.add(map2);

        //遍历List集合
        Iterator<Map<String, String>> iterator = bigList.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();
            //遍历Map集合
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            Iterator<Map.Entry<String, String>> iteratorSet = entrySet.iterator();
            while (iteratorSet.hasNext()) {
                Map.Entry<String, String> entry = iteratorSet.next();
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }
}