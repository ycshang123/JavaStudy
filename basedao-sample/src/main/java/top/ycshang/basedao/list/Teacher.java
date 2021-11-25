package top.ycshang.basedao.list;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-25 23:43
 **/
public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("老师在上课");
    }
}