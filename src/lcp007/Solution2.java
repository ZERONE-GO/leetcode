package lcp007;

class Solution2 {
    int ways = 0;

    public int numWays(int n, int[][] relation, int k) {
        int[][] map = new int[n][n];

        for (int i = 0; i < relation.length; i++) {
            map[relation[i][0]][relation[i][1]] = 1;
        }
        
        dfs(map, 0, k, n);

        return ways;
    }

    private void dfs(int[][] map, int pos, int k, int n) {
        if (k == 0) {
            if (pos == n - 1) {
                ways++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[pos][i] == 1) {
                dfs(map, i, k - 1, n);
            }
        }
    }
}
