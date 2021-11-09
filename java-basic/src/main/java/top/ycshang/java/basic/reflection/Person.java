package top.ycshang.java.basic.reflection;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-11-09 22:41
 **/
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void getPerson() {
        System.out.println("I am a Person");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}