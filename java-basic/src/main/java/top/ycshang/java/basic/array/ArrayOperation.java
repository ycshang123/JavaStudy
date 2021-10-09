package top.ycshang.java.basic.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: java-basic
 * @description:初始化、排序、二分查找
 * @author: ycshang
 * @create: 2021-10-09 21:29
 **/
public class ArrayOperation {
    private static final int MAX_SIZE = 10;

    /**
     * 初始化数组
     *
     * @return
     */
    public static int[] initialize() {
        int[] data = new int[MAX_SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            int num = random.nextInt(100);
            data[i] = num;
        }
        return data;
    }

    /**
     * 二分查找
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.println("\n当前数组元素为:");
        for (int n : arr) {
            System.out.printf("%-4d", n);
        }
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param key
     * @return查找成功的索引
     */
    public static int binarySearch(int[] arr, int key) {
        //定义二分查找的左、右边界
        int low = 0;
        int height = arr.length - 1;
        //定义middle
        int middle;
        //要查的元素比第一个小，比最后一个数大
        if (key < arr[low] || key > arr[height]) {
            return -1;
        }
        //循环折半
        while (low <= height) {
            middle = (low + height) / 2;
            //中位数比关键字大,则关键字在左边
            if (arr[middle] > key) {
                height = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(PackageConst.INFO);
        //初始化
        int[] arr = ArrayOperation.initialize();
        printArray(arr);
        //排序
        Arrays.sort(arr);
        printArray(arr);
        //输入待检查元素
        System.out.println("\n请输入待检查元素");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        while (key != -1) {
            //二分查找
            int index = binarySearch(arr, key);
            System.out.printf("\n%d 查找定位结果: %d", key, index);
            System.out.println("\n请输入待查元素");
            key = scanner.nextInt();
        }
        System.out.println("查找结束！");
    }
}