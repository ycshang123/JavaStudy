package top.ycshang.java.basic.oop;

import lombok.Data;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-15 21:01
 **/
@Data
public class Address implements Cloneable {
    private Integer id;
    private String describe;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
        return super.clone();
    }
}