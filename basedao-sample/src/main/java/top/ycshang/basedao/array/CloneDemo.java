package top.ycshang.basedao.array;

import java.util.Arrays;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-19 20:05
 **/
public class CloneDemo {
    public static void main(String[] args) {
        //cloneTest1();
        cloneTest2();
    }

    private static void cloneTest1() {
        int[] arr1 = new int[]{1, 0, 0, 8, 6};
        int[] arr2 = new int[arr1.length];
        arr2.clone();

        System.out.println("arr1=" + Arrays.toString(arr1));
        System.out.println("arr2=" + Arrays.toString(arr2));
        System.out.println("==============================");
        //    改变拷贝后的数组值，原数组并未跟着改变，表明对于基本数据类型，clone是深拷贝
        arr2[0] = 100;
        System.out.println("arr1=" + Arrays.toString(arr1));
        System.out.println("arr2=" + Arrays.toString(arr2));
    }

    private static  void  cloneTest2(){
        User user1 = new User("aaa",18);
        User user2 = new User("bbb",20);
        User[] users = new User[2];
        users[0] = user1;
        users[1] = user2;

        User[] users1 = users.clone();
        System.out.println("users="+ Arrays.toString(users));
        System.out.println("users="+ Arrays.toString(users1));
        System.out.println("==============================");
        //    改变拷贝后的数组值，原数组也跟着改变，表明对于引用数据类型，clone是浅拷贝
        users1[0].setName("ccc");
        users1[0].setAge(200);
        System.out.println("users="+ Arrays.toString(users));
        System.out.println("users="+ Arrays.toString(users1));
    }
}