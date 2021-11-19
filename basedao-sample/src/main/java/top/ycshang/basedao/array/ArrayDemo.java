package top.ycshang.basedao.array;

import java.util.Arrays;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-19 19:30
 **/
public class ArrayDemo {
    public static void main(String[] args) {
        //copySelf();
        //copyToOther();
        //getStringArrayFromObjectArray();
        //getStringArrayFromObjectArray1();
        multiDimensionalArrayCopy();
        //beanArrayCopy();
    }

    private static void copySelf() {
        int[] ids = {1, 2, 3, 4, 5};
        System.out.println("******************1******************");
        System.out.println("***********原数组*********");
        System.out.println(Arrays.toString(ids));
        //    把从索引0开始的2个数字复制到索引为3的位置上
        System.arraycopy(ids, 0, ids, 3, 2);
        System.out.println("****************复制后结果******************");
        System.out.println(Arrays.toString(ids));
    }


    private static void copyToOther() {
        int[] ids = {1, 2, 3, 4, 5};
        //    将数据的索引1开始的3个数据复制到目标的索引为0的位置上
        int[] other = new int[5];
        System.out.println("*******************2*****************");
        System.arraycopy(ids, 1, other, 0, 3);
        //    深拷贝
        System.out.println("******原数组****");
        System.out.println(Arrays.toString(ids));
        System.out.println("*********其他数组**********");
        System.out.println(Arrays.toString(other));
    }

    /**
     * 获取Object数组中的字符串类型数据
     */
    private static void getStringArrayFromObjectArray() {
        Object[] obj3 = {1, 2, 3, "4", "5"};
        String[] obj4 = new String[5];
        try {
            System.arraycopy(obj3, 2, obj4, 2, 3);
        } catch (Exception e) {
            //transfer exception:java.lang.ArrayStoreException
            System.out.println("transfer exception:" + e);
        }
        System.out.println("*******************3*****************");
        System.out.println("******原数组****");
        System.out.println(Arrays.toString(obj3));
        //浅拷贝
        System.out.println("*********其他数组**********");
        System.out.println(Arrays.toString(obj4));
    }

    /**
     * 获取Object数组中的字符串类型数据
     */
    private static void getStringArrayFromObjectArray1() {
        Object[] obj3 = {1, 2, 3, "4", "5"};
        String[] obj4 = new String[5];
        try {
            System.arraycopy(obj3, 3, obj4, 3, 2);
        } catch (Exception e) {
            System.out.println("transfer exception:" + e);
        }
        System.out.println("*******************4*****************");
        System.out.println("******原数组****");
        System.out.println(Arrays.toString(obj3));
        System.out.println("*********其他数组**********");
        System.out.println(Arrays.toString(obj4));
        obj3[3] = "ZhangSan";
        System.out.println("*********证明还是浅拷贝*********");
        System.out.println(Arrays.toString(obj3));
        System.out.println(Arrays.toString(obj4));

    }

    /**
     * 多维数组复制
     */
    private static void multiDimensionalArrayCopy() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] arr3 = {5, 6};

        int[][] src = new int[][]{arr1, arr2, arr3};
        print("原始输出：", src);
        int[][] dest = new int[3][];
        System.arraycopy(src, 0, dest, 0, 3);

        System.out.println("改变前");
        print("src = ", src);
        print("dest = ", dest);

        //原数组改变后观察新数组是否改变，改变->浅复制，不改变->深复制
        src[0][0] = -1;

        System.out.println("改变后");
        print("src = ", src);
        print("dest = ", dest);
    }

    /**
     * 打印数组
     *
     * @param string 字符串
     * @param arr    二维数组入参
     */
    private static void print(String string, int[][] arr) {
        System.out.print(string);
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print(",");
        }
        System.out.println();
    }


    /**
     * 对象数组拷贝
     */
    private static void beanArrayCopy() {
        User user1 = new User("aaa", 18);
        User user2 = new User("bbb", 18);
        User user3 = new User("ccc", 18);
        User[] userArraySrc = {user1, user2, user3};
        User[] userArrayDest = new User[3];
        System.out.println("对象数组复制，原始输出：" + Arrays.toString(userArraySrc));
        System.arraycopy(userArraySrc, 0, userArrayDest, 0, userArraySrc.length);
        System.out.println("userArrayDest," + Arrays.toString(userArrayDest));
        System.out.println("------------改变原对象------------------");
        userArraySrc[0] = new User("ddd", 20);
        System.out.println("***" + Arrays.toString(userArraySrc));
        System.out.println("***" + Arrays.toString(userArrayDest));
    }
}