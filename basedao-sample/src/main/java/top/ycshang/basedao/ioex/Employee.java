package top.ycshang.basedao.ioex;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-16 20:10
 **/
public class Employee implements java.io.Serializable {
    // 加⼊序列版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public String address;
    // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值
    //public int eid;
    public int age;

    public void addressCheck() {
        System.out.println("Address check : " + name + " -- " + address);
    }
}