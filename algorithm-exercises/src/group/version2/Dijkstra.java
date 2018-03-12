package group.version2;

/**
 * Created by theozhang on 10/10/17.
 */
public class Dijkstra {
    private static final int MAXINT = 32767;
    private static final int MAXNUM = 6;
    private static int[] dist = new int[MAXNUM];
    //前驱节点
    private static int[] prev = new int[MAXNUM];

    private static int[][] A = {
            {0,7,9,MAXINT,MAXINT,14},
            {7,0,10,15,MAXINT,MAXINT},
            {9,10,0,11,MAXINT,2},
            {MAXINT,15,11,0,6,0,9},
            {MAXINT,MAXINT,MAXINT,6,0,9},
            {14,MAXINT,2,MAXINT,9,0}
        };

    private static void dijkstra(int v0) {
        boolean[] s = new boolean[MAXNUM];
        int n = MAXNUM;
        for (int i = 0; i < n; ++i) {
            dist[i] = A[v0][i];
            s[i] = false;
            if (dist[i] == MAXINT) {
                prev[i] = -1;
            } else {
                prev[i] = v0;
            }
        }
        dist[v0] = 0;
        s[v0] = true;
        for (int i = 0; i < n; i++) {
            int minDist = MAXINT;
            int u = v0;
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && dist[j] < minDist) {
                    u = j;
                    minDist = dist[j];
                }
            }
            s[u] = true;
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && A[u][j] < MAXINT) {
                    if (dist[u] + A[u][j] < dist[j]) {
                        dist[j] = dist[u] + A[u][j];
                        prev[j] = u;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        dijkstra(1);
        System.out.println(dist.toString());
    }
}
