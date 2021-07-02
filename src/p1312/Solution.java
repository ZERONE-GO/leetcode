package p1312;

import java.util.Arrays;

class Solution {
    public int minInsertions(String s) {
        int[][] backup = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(backup[i], -1);
        }

        return dp(s, 0, s.length() - 1, backup);
    }

    private int dp(String s, int i, int j, int[][] backup) {
        if (i >= j) {
            return 0;
        }

        if (backup[i][j] != -1) {
            return backup[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            backup[i][j] = dp(s, i + 1, j - 1, backup);
        } else {
            backup[i][j] = Math.min(dp(s, i + 1, j, backup), dp(s, i, j - 1, backup)) + 1;

        }
        return backup[i][j];
    }

}