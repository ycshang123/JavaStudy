package top.ycshang.java.basic.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: JavaStudy
 * @description:选择排序
 * @author: ycshang
 * @create: 2021-10-04 18:52
 **/
@Slf4j
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 14, 90, 89, 13};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int j : arr) {
            log.info(j + "");
        }
    }
}