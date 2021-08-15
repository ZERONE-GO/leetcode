package p1713;

class Solution {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length, n = arr.length;
        int[][] map = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            map[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (target[i - 1] == arr[j - 1]) {
                    map[i][j] = map[i - 1][j - 1];
                } else {
                    map[i][j] = map[i - 1][j] + 1;
                }
                map[i][j] = Math.min(map[i][j], map[i][j - 1]);
            }
        }

        return map[m][n];
    }
}