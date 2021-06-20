package p5791;

public class Solution {

    int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid1[i][j] == 1 && grid2[i][j] == 1) {
                    grid2[i][j] = 2;
                }
            }
        }

        int res = 0;
        for(int i=0; i < m; i ++) {
            for(int j=0; j < n; j ++) {
                if(grid2[i][j] == 2) {
                    if(color(grid2, i, j)) {
                        res ++;
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean color(int[][] grid, int i, int j) {
        boolean res = true;
        grid[i][j] = 3;
        for(int k =0; k < direction.length; k ++) {
            int ni = i + direction[k][0];
            int nj = j + direction[k][1];
            if(ni >= 0 && ni < grid.length && nj >=0 && nj < grid[0].length) {
                if(grid[ni][nj] == 2) {
                    if(!color(grid, ni, nj)) {
                        res = false;
                    }
                } else if(grid[ni][nj] == 1) {
                    res = false;
                }
            }
        }
        return res;
    }
    
    public static void main(String args[]) {
        int[][] grid1 = {{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};
        int[][] grid2 = {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};
        Solution  s = new Solution();
        System.out.println(s.countSubIslands(grid1, grid2));
    }
}
