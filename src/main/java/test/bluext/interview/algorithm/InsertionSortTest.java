package test.bluext.interview.algorithm;

import java.util.Arrays;

/**
 * Description：插入排序测试
 * 插入排序: 设索引值i=1 , 从arr[i]开始向右递进 , 每次将arr[i]的值保存为key副本 , 此时arr[0] ~ arr[i]形成对比区间 ,
 * 设索引值 j=i-1 , 在对比区间中将key和arr[j]比较 , 如果arr[j]>key且j>=0 , 则将较大值设定为arr[j+1](第一次交换因为key已保存arr[i]的值 , 所以并不会丢失值) ,
 * 随后j自减 , 继续下一次比较. 直到不满足 arr[j]>k 或 j>=0为止.中止循环时 , 将key值保存到arr[j+1]中.
 * 产生的效果就是在比较区间内 , 先取arr[i]的值为key作为对比值 , 随着j--的变化 , arr[j]取值不断向前递进 , 直到遇到arr[j] < key , 或者超出比较区间 , 中止循环.
 * 如果是超出比较区间中止循环 , 说明key值是比较区间中最小的值 , 此时j=-1 , 赋值arr[j+1]=key即当前数组首位元素为本次区间内最小值.
 * 如果是遇到arr[j] < key中止循环 , 则说明前i-1轮筛选出的当前位置的值本轮仍然较小 , 当前轮次的key值合适的位置为arr[j+1].
 * 因为比较区间从小到大变化 , 可以保证第i轮比较的值 , 除元素arr[i]外 , 已经在前i-1轮完成了比较. 而比较结果是可以传递的.
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 10:04
 */
public class InsertionSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 1, 19, 3, 31, 24, 11, 9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
