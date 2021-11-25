package top.ycshang.basedao.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-26 00:14
 **/
public class MapNestMap {
    public static void main(String[] args) {
        //创建基础班集合
        Map<String, String> javase = new HashMap<>(8);
        javase.put("001", "张三");
        javase.put("002", "李四");

        //创建就业班集合
        Map<String, String> javaee = new HashMap<>(8);
        javaee.put("001", "王五");
        javaee.put("002", "赵六");

        //创建集合，键是班级的名字，值是两个班级的集合HashMap
        Map<String, Map<String, String>> map = new HashMap<>(8);

        //将班级集合添加到集合
        map.put("基础班", javase);
        map.put("就业班", javaee);

        //keySet0(map);
        entrySet0(map);
    }

    /**
     * 定义方法，实现迭代Map集合嵌套，entrySet
     */
    public static void entrySet0(Map<String, Map<String, String>> map) {
        //集合方法 map entrySet() 获取集合键值对关系对象Map.Entry存储到Set集合
        Set<Map.Entry<String, Map<String, String>>> set = map.entrySet();
        //迭代班级集合Set
        Iterator<Map.Entry<String, Map<String, String>>> it = set.iterator();
        while (it.hasNext()) {
            //it获取 next获取到是一个 Map.Entry对象
            Map.Entry<String, Map<String, String>> entryClassName = it.next();
            //Map.Entry方法 getKey getValue 获取键和值
            String className = entryClassName.getKey();
            Map<String, String> classMap = entryClassName.getValue();
            //迭代小集合，班级集合 classMap
            //classMap集合方法 entrySet 获取小集合的键值对关系对象存储到Set集合
            Set<Map.Entry<String, String>> setClass = classMap.entrySet();
            //迭代小集合，班级集合键值对关系对象 setClass
            Iterator<Map.Entry<String, String>> itClass = setClass.iterator();
            while (itClass.hasNext()) {
                //itClass.next()方法，获取的是班级集合的键值对关系对象
                Map.Entry<String, String> entryClass = itClass.next();
                //getKey  getValue方法获取
                String number = entryClass.getKey();
                String name = entryClass.getValue();
                System.out.println(className + ":" + number + ":" + name);
            }
        }
    }

    /**
     * 定义方法，实现迭代Map嵌套集合，keySet
     */
    public static void keySet0(HashMap<String, HashMap<String, String>> map) {
        //集合方法 map keySet()获取集合的所有的键存储Set集合
        Set<String> setClassName = map.keySet();
        //迭代Set集合
        Iterator<String> itClassName = setClassName.iterator();
        while (itClassName.hasNext()) {
            //next()获取出来的Set集合，Set集合存储是大集合的键：班级名字
            String className = itClassName.next();
            //大集合map get方法获取值，值是另一个集合
            HashMap<String, String> classMap = map.get(className);
            //对班级集合 classMap 迭代集合方法keySet将所有的键，存储到Set集合
            Set<String> setNumber = classMap.keySet();
            Iterator<String> itNumber = setNumber.iterator();
            while (itNumber.hasNext()) {
                //next方法 获取的是班级小集合，键为学号
                String number = itNumber.next();
                //班级小集合get方法获取值
                String name = classMap.get(number);
                //输出班级名字，学号和学生姓名
                System.out.println(className + ".." + number + ".." + name);
            }
        }
    }
}