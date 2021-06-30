package sort;

import sort.api.Sort;

import java.util.Arrays;

/**
 * @author theozhang on 3/12/18
 */
public class MergeSort extends Sort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {2, 3, 4, 15, 6, 2};
        System.out.println(Arrays.toString(mergeSort.sort(a, 0, a.length - 1)));
    }

    /**
     * 把待排序的数组分成左右两部分，然后把左右两部分排序完成的结果，合并成一个
     */
    public int[] sort(int[] a, int l, int r) {
        if (l == r) {
            return new int[]{a[l]};
        }
        int mid = (l + r) / 2;
        int[] leftArray = sort(a, l, mid);
        int[] rightArray = sort(a, mid + 1, r);
        return merge(leftArray, rightArray);
    }

    /**
     * 合并左右两个数组
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    public int[] merge(int[] leftArray, int[] rightArray) {
        int[] tmp = new int[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        while (i < leftArray.length || j < rightArray.length) {
            if (i == leftArray.length) {
                while (j < rightArray.length) {
                    tmp[i + j] = rightArray[j];
                    j++;
                }
                break;
            }
            if (j == rightArray.length) {
                while (i < leftArray.length) {
                    tmp[i + j] = leftArray[i];
                    i++;
                }
                break;
            }
            if (leftArray[i] < rightArray[j]) {
                tmp[i + j] = leftArray[i];
                i++;
            } else {
                tmp[i + j] = rightArray[j];
                j++;
            }
        }
        return tmp;
    }
}
