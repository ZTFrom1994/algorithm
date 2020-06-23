package group.version2;

import java.util.Arrays;

/**
 * Created by theozhang on 10/10/17.
 */
public class Dijkstra {
    private static final int MAX_INT = 32767;
    private static final int MAX_NUM = 6;
    private static int[] dist = new int[MAX_NUM];
    //前驱节点
    private static int[] prev = new int[MAX_NUM];

    private static int[][] A = {
            {0,7,9, MAX_INT, MAX_INT,14},
            {7,0,10,15, MAX_INT, MAX_INT},
            {9,10,0,11, MAX_INT,2},
            {MAX_INT,15,11,0,6,0,9},
            {MAX_INT, MAX_INT, MAX_INT,6,0,9},
            {14, MAX_INT,2, MAX_INT,9,0}
        };

    private static void dijkstra(int v0) {
        boolean[] s = new boolean[MAX_NUM];
        int n = MAX_NUM;
        for (int i = 0; i < n; ++i) {
            dist[i] = A[v0][i];
            s[i] = false;
            if (dist[i] == MAX_INT) {
                prev[i] = -1;
            } else {
                prev[i] = v0;
            }
        }
        dist[v0] = 0;
        s[v0] = true;
        for (int i = 0; i < n; i++) {
            int minDist = MAX_INT;
            int u = v0;
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && dist[j] < minDist) {
                    u = j;
                    minDist = dist[j];
                }
            }
            s[u] = true;
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && A[u][j] < MAX_INT) {
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
        System.out.println(Arrays.toString(dist));
    }
}
