package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 22:06
 **/
public class Person {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        this.name = "mike";
        System.out.println("创建了一个对象");
    }

    public Person(Integer x, String y) {
        this.id = x;
        this.name = y;
    }
}