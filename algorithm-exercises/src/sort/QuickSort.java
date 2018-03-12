package sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class QuickSort {
    private static int[] a = {5,4,3,2,1};

    public static void main(String[] args) {
        sort(0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static int pagnation(int low, int high) {
        int k = low;
        while (low < high) {
            while (low <= high && a[low] <= a[k]) low++;
            while (high >= low && a[high] >= a[k]) high--;
            if (low >= high) break;
            exchange(low, high);
        }
        exchange(k, high);
        return high;
    }

    public static void sort(int low, int high) {
        if (low >= high)
            return;
        int k = pagnation(low, high);
        sort(low, k - 1);
        sort(k + 1, high);
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
