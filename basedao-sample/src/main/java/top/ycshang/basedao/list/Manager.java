package top.ycshang.basedao.list;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-25 23:43
 **/
public class Manager extends Employee {
    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("班主任管理班级");
    }
}