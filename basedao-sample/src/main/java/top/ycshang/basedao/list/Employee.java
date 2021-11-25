package top.ycshang.basedao.list;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-25 23:42
 **/
public abstract class Employee {
    private String name;
    private int age;
    public Employee() {
    }
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void work();
}