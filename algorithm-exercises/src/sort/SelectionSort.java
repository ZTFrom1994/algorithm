package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class SelectionSort extends Sort {
    public int a[] = {2,3,4,15,6,2};

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort();
    }

    public  void sort() {
        for (int i = 0;i < a.length;i++){
            int minIndex = i;
            for (int j = i + 1;j < a.length;j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
        System.out.println(Arrays.toString(a));
    }
}
