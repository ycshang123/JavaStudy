package top.ycshang.java.basic.serizlize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @program: java-basic
 * @description:学生类
 * @author: ycshang
 * @create: 2021-10-18 21:33
 **/
public class Student implements Serializable {
    private String name;
    private Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        //调节默认的反序列化函数
        objectInputStream.defaultReadObject();
        //手工检查反序列化后学生成绩的有效性，若发现问题，终止操作！
        if (0 > score || 100 < score) {
            throw new IllegalArgumentException("学生分数只能再0——100之间");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}