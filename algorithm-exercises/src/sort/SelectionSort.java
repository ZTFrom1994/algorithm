package sort;

/**
 * @author theozhang on 3/12/18
 */
public class SelectionSort {
    public static int a[] = {2,3,4,15,6,2};

    public static void main(String[] args) {
        for (int i = 0;i < a.length;i++){

        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
