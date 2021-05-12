package p0051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        boolean[][] map = new boolean[n][n];
        nQueeens(map, n, n);
        return result;
    }

    private void nQueeens(boolean[][] map, int n, int size) {
        if (n == 0) {
            List<String> res = new ArrayList<String>();
            for(int i=0;i <size; i ++) {
                StringBuilder sb =new StringBuilder();
                for(int j=0; j < size; j ++ ) {
                    if(map[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            result.add(res);
        }
        for (int i = 0; i < size; i++) {
            if(check(map, size-n, i)) {
                map[size-n][i] = true;
                nQueeens(map, n-1, size);
                map[size-n][i] = false;
            }
        }
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

}
