package p0664;

import java.util.Arrays;

class Solution {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] map = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        return solve(s, 0, len - 1, map);
    }

    private int solve(String s, int left, int right, int[][] map) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return 1;
        }

        if (map[left][right] != Integer.MAX_VALUE) {
            return map[left][right];
        }

        if (s.charAt(left) == s.charAt(right)) {
            map[left][right] = solve(s, left, right - 1, map);
        } else {
            for (int i = left; i < right; i++) {
                map[left][right] = Math.min(map[left][right], solve(s, left, i, map) + solve(s, i + 1, right, map));
            }
        }

        return map[left][right];
    }

}