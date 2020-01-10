package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by Theo Zhang on 2020/1/10.
 */
public class BubbleSort extends Sort {

    public static void main(String[] args) {
        int[] array = {0, 3, 2, 5, 2, 1, 7, 10, 9, 11, 8, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void bubbleSort(int[] array) {
        //冒泡n-1轮后，n-1个元素已经按顺序排到最后了，此时数组的第一个元素肯定是最小的，不需要再来一轮冒泡了
        for (int i = 0; i < array.length - 1; i++) {
            //最后一个元素不需要与后面一个元素比较大小，所以[array.length - 1]
            //同时 每一轮冒泡只要到上一轮冒泡元素的位置即可，因为每轮冒泡都会把当前最大的冒泡到数组后面 故 array.length - 1 - i;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
