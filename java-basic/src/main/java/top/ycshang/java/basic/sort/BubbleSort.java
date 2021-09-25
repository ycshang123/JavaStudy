package top.ycshang.java.basic.sort;

/**
 * @program: java-basic
 * @description:冒泡排序
 * @author: ycshang
 * @create: 2021-09-24 20:08
 **/
public class BubbleSort {

    public static void bubbleSort(int[] a, int n) {
        int i, j;
        for (i = 0; i < n - i; i++) {
            for (j = 1; j < n - i; j++) {
                //前面的数字大于后面的数字就交换
                if (a[j - 1] > a[j]) {
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }

            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 10, 29, 3, 4, 9, 98, 30};
        BubbleSort.bubbleSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}