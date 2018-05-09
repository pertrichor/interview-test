package test.bluext.interview.algorithm;

import java.util.Arrays;

/**
 * Description：冒泡排序测试
 * 冒泡排序: 一共进行arr.length-1轮 , 每一轮的目标是从左到右的arr.length-i-1个元素 , 从左向右两两相互比较 , 将比较大的数交换到每一轮的最右边.
 * 每一轮将最大的数"冒泡"到最右边 , 所有轮数比较完毕即得到从小到大的排序结果. 从大到小同理 , 修改比较符即可.
 * <p>
 * 实现简单 , 效率低
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 9:15
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 1, 19, 3, 31, 24, 11, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
}
