package test.bluext.interview.algorithm;

import java.util.Arrays;

/**
 * Description：快速排序测试
 * 快速排序:
 * 1.一次快速排序:
 * 默认指定数组的第一个元素作为临界值 , 使用low指针指向临界值 , low指针由于指向临界值(需要维护这个值) , 所以low指针静止 , high指针从最末端开始向前移动(寻找小于临界值的值).
 * 当high指针移动 , 如果当前值 < 临界值 , 则将此值和临界值交换. 交换后 , high指针指向临界值 , 所以high指针静止 , low指针移动. 如果大于等于临界值 , 则继续向前移动.
 * 当low指针移动 , 如果当前值 > 临界值 , 则将此值和临界值交换. 交换后 , low指针指向临界值 , 所以low指针静止 , high指针移动. 如果小于等于临界值 , 则继续向前移动.
 * 周而复始.
 * 结果就是 , 所有比临界值小的值被移动到临界值左侧 , 所有比临界值大的值被移动到临界值右侧. 此时返回临界值当前所在的指针位置.
 * <p>
 * 2.完成一次快速排序后 , 将临界值所在的位置作为分界点. 将上一次快速排序的区间分为两个部分 , 每个部分继续完成一次快速排序.
 * <p>
 * 3.一次快速排序完成后都需要进行前后两个区间的递归排序 , 除非最新的临界值指针触碰到了low或high边界 , 说明可以退出递归.
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 10:39
 */
public class FastSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 1, 19, 3, 31, 24, 11, 9};
        fastSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 递归快速排序
    public static void fastSort(int[] arr, int low, int high) {
        if (low < high) {
            int pos = oneFastSort(arr, low, high);
            fastSort(arr, low, pos - 1);
            fastSort(arr, pos + 1, high);
        }
    }

    // 一次快速排序
    private static int oneFastSort(int[] arr, int low, int high) {
        boolean fromHigh = true;// 是否从high指针一侧开始遍历
        while (low != high) {
            if (fromHigh) {
                if (arr[low] > arr[high]) {
                    // low标值 > high标值 , 交换值 , 移动权交给low指针
                    swap(arr, low, high);
                    low++;
                    fromHigh = false;
                } else {
                    // low标值 <= high标值 , high指针前移
                    high--;
                }
            } else {
                if (arr[low] > arr[high]) {
                    // low标值 > high标值 , 交换值 , 移动权交给high指针
                    swap(arr, low, high);
                    high--;
                    fromHigh = true;
                } else {
                    // low标值 <= high标值 , low指针前移
                    low++;
                }
            }
        }

        return low;// 返回low或high为同一个值 , 当两者重合时 , 因为维护临界值的指针是静止的 , 所以总是有移动权的指针向维护临界值的指针移动 , 完成重合.
    }

    // 交换值
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
