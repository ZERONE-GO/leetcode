package p0064;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = Integer.MAX_VALUE;
                if (i > 0) {
                    value = Math.min(value, grid[i - 1][j]);
                }
                if (j > 0) {
                    value = Math.min(value, grid[i][j - 1]);
                }
                grid[i][j] = value == Integer.MAX_VALUE ? grid[i][j] : value + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

}
