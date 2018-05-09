package test.bluext.interview.algorithm;

/**
 * Description：二分/折半查找法测试
 * <p>
 * 二分/折半查找法: 前提是查找的数据已经完成排序. 查找时首先确定比较范围 , 定义指针low , high , middle , 分别对应比较范围的开始 , 结束 , 中间值.
 * 其中 middle = (low + high) / 2.<br/>
 * 每次查找时 , 如果arr[middle] = 目标值target , 则直接返回middle.<br/>
 * 如果arr[middle] > 目标值target , 由于数组是有序的 , 所以比较范围缩小为low ~ middle-1 , 赋值high = middle-1 , 重新计算middle = (low + high) / 2.<br/>
 * 如果arr[middle] < 目标值target , 同理 , 比较范围缩小为 middle+1 ~ high , 赋值low = middle+1 , 重新计算middle = (low + high) / 2.<br/>
 * (循环/递归)重启查找 , 直到arr[middle] = 目标值target , 或者low和high边界重合 , 返回-1(未查找到结果).
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 14:25
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 10, 0, arr.length - 1));
    }

    // 循环实现
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low != high) {
            int middle = (low + high) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    // 递归实现
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (arr[high] < target || arr[low] > target || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target) {
            return binarySearch(arr, target, low, middle - 1);
        } else {
            return binarySearch(arr, target, middle + 1, high);
        }
    }

}
