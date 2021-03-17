package p0115;

import java.util.Arrays;

public class Solution {

    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        boolean[][] map = new boolean[t.length()][s.length()];

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = (t.charAt(i) == s.charAt(j));
            }
        }

        int[][] backup = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            Arrays.fill(backup[i], -1);
        }
        int result = distinct(map, backup, s.length(), t.length());
        return result;
    }

    public int distinct(boolean[][] map, int[][] backup, int s, int t) {
        if (t <= 0) {
            return 1;
        }
        if (s < 0) {
            return 0;
        }

        int result = 0;
        for (int i = s - 1; i >= 0; i --) {
            if (map[t - 1][i]) {
                if (backup[t - 1][i] == -1) {
                    backup[t - 1][i] = distinct(map, backup, i, t-1);
                }
            } else {
                backup[t - 1][i] = 0;
            }
            result += backup[t - 1][i];
        }
        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.numDistinct("rabbbit", "rabbit"));
        System.out.println(s.numDistinct("babgbag", "bag"));
    }

}
