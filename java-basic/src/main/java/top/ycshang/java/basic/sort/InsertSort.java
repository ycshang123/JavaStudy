package top.ycshang.java.basic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @program: java-basic
 * @description: 直接插入排序
 * @author: ycshang
 * @create: 2021-10-05 20:20
 **/
@Slf4j
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6, 9, 18, 26, 89, 37};
        log.info("排序之前:{}", Arrays.toString(arr));
        insertSort(arr);
        log.info("排序之后:{}", Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        //已排序数组下标
        int j;
        //未排序元素
        int t;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                //赋值给待排序元素
                t = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > t; j--) {
                    //从后往前遍历；逐个和待排序元素比较；如果已排序元素较大，后移
                    arr[j + 1] = arr[j];
                }
                //将待排序元素插入到正确的位置
                arr[j + 1] = t;
            }
        }
    }
}