package top.ycshang.java.basic.array;

/**
 * @program: java-basic
 * @description: 数组练习
 * @author: ycshang
 * @create: 2021-09-23 22:21
 **/
public class ArrayDemo {
    /**
     * 求数组元素和
     * @param arry
     * @return
     */
    public int getSum(int[] arry){
        //sum 为累加器，初始化为0
        int sum =0;
        for(int i=0;i<arry.length;i++){
            sum +=i;
        }
        //返回sum
        return sum;
    }
}