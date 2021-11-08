package top.ycshang.java.basic.proxy;

/**
 * @program: java-basic
 * @description: 实现类
 * @author: ycshang
 * @create: 2021-11-08 22:31
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}