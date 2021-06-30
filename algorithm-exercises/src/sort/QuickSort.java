package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class QuickSort extends Sort {

    public int[] a = {5, 4, 3, 2, 1};

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickSort.a, 0, quickSort.a.length - 1);
        System.out.println(Arrays.toString(quickSort.a));
    }

    /**
     * 此函数返回一个k位置，所有小于k位置的值都会被放到k左边，所有大于k位置的都会放到k右边
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public int arrange(int[] a, int low, int high) {
        int k = low;//目标元素位置，默认取范围内第一个即可，取其他的也行的
        while (low < high) {
            //找到第一个大于k位置的值
            while (low < high && a[low] < a[k]) low++;
            //找到第一个小于k位置的值
            while (low < high && a[high] > a[k]) high--;
            swap(a, low, high);
        }
        swap(a, k, high);
        return high;
    }

    /**
     * 快速排序核心思想：只要找到每一个元素在整个有序序列的位置，就可以完成排序
     * arrange函数：找到low位置在low-high范围内的目标位置，返回这个位置k
     * 实现方法：找到low位置在整个范围内排序后应该所处的位置，然后对K的左边和k的右边递归排序
     *
     * @param a
     * @param low
     * @param high
     */
    public void sort(int[] a, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int k = arrange(a, low, high);
        //对k左边排序
        sort(a, low, k - 1);
        sort(a, k + 1, high);
    }
}
