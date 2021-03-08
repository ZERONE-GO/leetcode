package p1786;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static int MOD = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {
        int[] weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[n] = 0;
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]][edges[i][1]] = edges[i][2];
            map[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        List<Integer> bst = new ArrayList<>();
        bst.add(n);

        for (int i = 0; i < bst.size(); i++) {
            for (int j = 1; j <= n; j++) {
                if (map[j][bst.get(i)] != 0) {
                    if (weights[j] > weights[bst.get(i)] + map[j][bst.get(i)]) {
                        weights[j] = weights[bst.get(i)] + map[j][bst.get(i)];
                        bst.add(j);
                    }
                }
            }
        }

        int[] color = new int[n + 1];
        color[1] = 1;
        int[] backup = new int[n + 1];
        Arrays.fill(backup, -1);
        return ds(1, color, weights, map, n, backup);
    }

    private int ds(int index, int[] color, int[] weights, int[][] map, int n, int[] backup) {
        if (index == n) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (map[index][i] != 0 && color[i] == 0 && weights[index] > weights[i]) {
                color[i] = 1;
                if (backup[i] == -1) {
                    backup[i] = ds(i, color, weights, map, n, backup);
                }
                result += backup[i];
                result = result % MOD;
                color[i] = 0;
            }
        }

        return result % MOD;
    }

}
