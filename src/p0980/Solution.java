package p0980;

public class Solution {

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int r = 0, c = 0, step = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    step++;
                } else if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        return ds(grid, r, c, m, n, step);
    }

    private int ds(int[][] grid, int i, int j, int m, int n, int step) {
        if (step == 0) {
            if (grid[i][j] == 2) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;

        for (int[] d : directions) {
            int r = i + d[0], c = j + d[1];

            if (r >= 0 && r < m && c >= 0 && c < n) {
                if(step > 1 && grid[r][c] == 0) {
                    grid[r][c] = 1;
                    ans += ds(grid, r, c, m, n, step - 1);
                    grid[r][c] = 0;
                } else if(step == 1 && grid[r][c] == 2) {
                    ans += ds(grid, r, c, m, n, step - 1);
                }

            }
        }

        return ans;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
//        int[][] grid = {{1,2}};
        System.out.println(s.uniquePathsIII(grid));
    }
}
