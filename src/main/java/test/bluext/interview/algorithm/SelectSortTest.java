package test.bluext.interview.algorithm;

import java.util.Arrays;

/**
 * Description：选择排序
 * 选择排序: 一共arr.length-1轮 , 每轮待比较值是arr[i]和arr[i+1] ~ arr[arr.length-1]. 每次比较 , 如果arr[i]较大 ,
 * 则把较小值交换到arr[i]. 每轮随着arr[i]的向右递进 , 最小值被不断交换到arr[i]中 , 实现了排序效果. 从大到小同理.
 * 类似于冒泡排序 , 可以描述为"沉底排序".
 * <p>
 * 实现简单 , 效率低
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 9:28
 */
public class SelectSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 1, 19, 3, 31, 24, 11, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }
    }

}
