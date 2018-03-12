package sort.api;

/**
 * @author theozhang on 3/12/18
 */
public class Sort {
     public void exchange(int[] a, int i, int j) {
          int t = a[i];
          a[i] = a[j];
          a[j] = t;
     }
}
