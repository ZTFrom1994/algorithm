package sort.api;

/**
 * @author theozhang on 3/12/18
 */
public interface HeapHandleable {
    void sink(int[] a,int i,int j);
    void swim(int[] a,int i,int j);
}
