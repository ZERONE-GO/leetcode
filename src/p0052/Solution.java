package p0052;

public class Solution {

    public int totalNQueens(int n) {
        boolean[][] map = new boolean[n][n];
        return nQueeens(map, n, n);
    }

    private int nQueeens(boolean[][] map, int n, int size) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < size; i++) {
            if(check(map, size-n, i)) {
                map[size-n][i] = true;
                res += nQueeens(map, n-1, size);
                map[size-n][i] = false;
            }
        }
        return res;
    }

    private boolean check(boolean[][] map, int r, int c) {
        // up
        for (int i = r - 1; i >= 0; i--) {
            if (map[i][c]) {
                return false;
            }
        }
        // topup
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j]) {
                return false;
            }
        }

        for (int i = r - 1, j = c + 1; i >= 0 && j < map.length; i--, j++) {
            if (map[i][j]) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        //System.out.println(s.totalNQueens(1));
        System.out.println(s.totalNQueens(2));
        System.out.println(s.totalNQueens(3));
        System.out.println(s.totalNQueens(4));
        System.out.println(s.totalNQueens(5));
        System.out.println(s.totalNQueens(6));
        System.out.println(s.totalNQueens(7));
        System.out.println(s.totalNQueens(8));
        System.out.println(s.totalNQueens(9));
    }

}
