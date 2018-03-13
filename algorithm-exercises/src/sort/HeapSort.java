package sort;

import sort.api.HeapHandleable;
import sort.api.Sort;

import java.util.Arrays;

/**
 * Min peak heap
 *
 * @author theozhang on 3/12/18
 */
public class HeapSort extends Sort implements HeapHandleable {
    //a[0] is used for filling index
    public int[] a = {0,3, 2, 5, 2, 1, 7, 10, 9, 11, 8, 6};

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.buildHeap(heapSort.a);
        heapSort.priorityPop(heapSort.a);
        System.out.println(Arrays.toString(heapSort.a));
    }

    public void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i > 0; i--) {
            sink(a, i, a.length - 1);
        }
    }

    public void priorityPop(int[] a){
        int end = a.length - 1;
        while (end > 0){
            exchange(a,1,end);
            sink(a,1,--end);
        }
    }

    @Override
    public void sink(int[] a, int i, int j) {
        int left = 2 * i;
        int right = 2 *i + 1;
        while (left <= j) {
            if (right > j){
                if (a[left] < a[i]){
                    exchange(a,left,i);
                    i = left;
                }else {
                    break;
                }
            }else {
                if (a[left] <= a[right] && a[i] > a[left]){
                    exchange(a,left,i);
                    i = left;
                }else if (a[left] >= a[right] && a[i] > a[right]){
                    exchange(a,right,i);
                    i = right;
                }else {
                    break;
                }
            }
            left = 2 * i;
            right = 2 * i + 1;
        }
    }

    @Override
    public void swim(int[] a, int i, int j) {

    }
}
