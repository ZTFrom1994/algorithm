package group.version1;

public class Stirling {
    public static void main(String[] args) {
        long count = 0;
        int size = 6;
        for (int i = 1; i <= size; i++) {
            count += Stirling(size,i);
        }
        System.out.println(count);
    }
    public static long Stirling(int n, int k)
    {
        if(n==1 && k==0) return 1;
        else if( k==1 || n==k ) return 1;
        else return Stirling(n-1, k)*k+Stirling(n-1, k-1);
    }
}
