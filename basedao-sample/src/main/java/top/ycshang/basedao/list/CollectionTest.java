package top.ycshang.basedao.list;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-25 23:18
 **/
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList();
        coll.add("abc");
        coll.add("itcast");
        //coll.add(5);//由于集合没有做任何限定，任何类型都可以给其中存放
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){
            //需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
            String str = (String) it.next();
            System.out.println(str.length());
        }
    }
    //public static void main(String[] args) {
    //    String s1 = new String("abc");
    //    String s2 = new String("abc");
    //    System.out.println(s1.hashCode());
    //    System.out.println(s2.hashCode());
    //}
    //public static void main(String[] args) throws UnsupportedEncodingException {
    //    List<Teacher> teacherList = new ArrayList<Teacher>();
    //    teacherList.add(new Teacher("张三",30));
    //    teacherList.add(new Teacher("李四",32));
    //    List<Manager> managerList = new ArrayList<Manager>();
    //    managerList.add(new Manager("王五",25));
    //    managerList.add(new Manager("赵六",23));
    //    getElement(teacherList);
    //    getElement(managerList);
    //}
    ////定义方法，参数为List集合，泛型被限定为Employee，可以接收的泛型为Employee或者子类
    //public static void getElement(List<? extends  Employee> list) {
    //    Iterator<? extends Employee> it = list.iterator();
    //    while (it.hasNext()) {
    //        Employee employee = it.next();
    //        System.out.println(employee.getName()+"::"+employee.getAge());
    //        employee.work();
    //    }
    //}
    //public static void main(String[] args) {
    //    ArrayList<Student> list = new ArrayList<Student>();
    //    list.add(new Student("rose", 18));
    //    list.add(new Student("jack", 16));
    //    list.add(new Student("abc", 20));
    //    Collections.sort(list, new Comparator<Student>() {
    //        @Override
    //        public int compare(Student o1, Student o2) {
    //            return o1.getAge() - o2.getAge();//以学生的年龄升序
    //        }
    //    });
    //
    //    for (Student student : list) {
    //        System.out.println(student.toString());
    //    }
    //}
    //public static void main(String[] args) {
    //    ArrayList<Integer> list = new ArrayList<Integer>();
    //    list.add(100);
    //    list.add(300);
    //    list.add(200);
    //    list.add(50);
    //    //排序方法
    //    Collections.sort(list);
    //    System.out.println(list);
    //}
}