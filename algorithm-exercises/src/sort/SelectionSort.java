package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class SelectionSort extends Sort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {2, 3, 4, 15, 6, 2};
        selectionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序：从未排序的列表中找出最小/大值，放在序列起始位置，然后再从未排序列表找出最小/大值，以此类推，得到排序后的序列
     * 实现方法：按顺序遍历，对于每个元素i，找出其后面所有元素的最小/大值，然后和i换位置，当全部遍历完成后，则排序完成
     */
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
}
