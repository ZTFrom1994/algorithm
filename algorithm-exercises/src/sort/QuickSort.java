package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class QuickSort extends Sort {
    public int[] a = {5,4,3,2,1};
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickSort.a,0, quickSort.a.length - 1);
        System.out.println(Arrays.toString(quickSort.a));
    }

    public int arrange(int[] a,int low, int high) {
        int k = low;
        while (low < high) {
            while (low <= high && a[low] <= a[k]) low++;
            while (high >= low && a[high] >= a[k]) high--;
            if (low >= high) break;
            exchange(a,low, high);
        }
        exchange(a,k, high);
        return high;
    }

    public void sort(int[] a,int low, int high) {
        if (low >= high)
            return;
        int k = arrange(a,low, high);
        sort(a,low, k - 1);
        sort(a,k + 1, high);
    }
}
