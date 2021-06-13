package p5202;

public class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[m+1][n];
        
        for(int i=0; i < m; i ++) {
            for(int j=0; j < n; j ++) {
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
            }
        }
        int res = 1; 
        for(int i=0; i < m; i ++) {
            for(int j=0; j < n; j ++) {
                for(int k= Math.min(i, j) + 1; k > res; k --) {
                    if(isMagicSquare(grid, rowSum, colSum, i, j, k)) {
                        res= k;
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isMagicSquare(int[][] grid, int[][] rowSum, int[][] colSum, int i, int j, int k) {
        int sum = rowSum[i][j+1] - rowSum[i][j- k + 1];
        
        // check rowSum
        for(int row=i; row >= i+1-k; row --) {
            if(sum != rowSum[row][j+1] - rowSum[row][j-k+1]) {
                return false;
            }
        }
        
        //check col sum
        for(int col = j; col >= j+1-k; col --) {
            if(sum != colSum[i+1][col] - colSum[i+1- k][col]) {
                return false;
            }
        }
        
        // 对角线
        int tmp = 0;
        for(int l = 0; l < k; l ++) {
            tmp += grid[i-l][j-l];
        }
        if(tmp != sum) {
            return false;
        }
        
        tmp = 0;
        int row = i+1-k, col = j;
        for(int l=0; l < k; l ++) {
            tmp += grid[row+l][col-l];
        }
        if(tmp != sum) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        Solution  s = new Solution();
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(s.largestMagicSquare(grid));
    }
}
