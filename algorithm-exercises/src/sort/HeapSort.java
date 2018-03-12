package sort;

import sort.api.HeapHandleable;
import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class HeapSort extends Sort implements HeapHandleable {

    public int[] a = {1, 23, 54, 12, 54, 12};

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.buildHeap(heapSort.a);
        System.out.println(Arrays.toString(heapSort.a));
    }

    public void buildHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            sink(a, i, a.length - 1);
        }
    }

    @Override
    public void sink(int[] a, int i, int j) {
        while (2 * i <= j) {
            if (2 * i == j) {
                if (a[i] > a[2 * i]) {
                    exchange(a, i, 2 * i);
                    i = 2 * i;
                }
            } else if (2 * i + 1 <= j) {
                if (a[2 * i] > a[2 * i + 1]) {
                    exchange(a,i,2 * i + 1);
                    i = 2 * i + 1;
                } else {
                    exchange(a,i,2 * i);
                    i = 2 * i;
                }
            }else {
                break;
            }
        }
    }

    @Override
    public void swim(int[] a, int i, int j) {

    }
}
