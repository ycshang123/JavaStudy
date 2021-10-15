package top.ycshang.java.basic.oop;

import lombok.Data;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-15 21:02
 **/
@Data
public class Student implements Cloneable {
    private Integer id;
    private String name;
    private Address address;

    //@Override
    //protected Object clone() throws CloneNotSupportedException {
    //浅拷贝
    //    return super.clone();
    //}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //深拷贝
        Student s = (Student) super.clone();
        s.address = (Address) this.address.clone();
        return s;
    }
}