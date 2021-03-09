package p0363;

public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int[][] sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                for (int l = i; l <= m; l++) {
                    for (int o = j; o <= n; o++) {
                        int s = sum[l][o] - sum[i - 1][o] - sum[l][j - 1] + sum[i - 1][j - 1];
                        if (s <= k && s > result) {
                            result = s;
                        }
                    }
                }
            }
        }

        return result;
    }

}
