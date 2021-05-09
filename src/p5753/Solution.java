package p5753;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 0; i < colors.length(); i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
        }

        int[] status = new int[colors.length()];
        int[][] map = new int[colors.length()][26];

        for (int i = 0; i < colors.length(); i++) {
            if (!dp(i, colors, list, status, map)) {
                return -1;
            }
        }

        int result = 0;
        for (int i = 0; i < colors.length(); i++) {
            for (int c = 0; c < 26; c++) {
                if (result < map[i][c]) {
                    result = map[i][c];
                }
            }
        }

        return result;
    }

    private boolean dp(int i, String colors, List<List<Integer>> list, int[] status, int[][] map) {
        if (status[i] == 1) {
            return false;
        }

        if (status[i] == 2) {
            return true;
        }

        status[i] = 1;
        List<Integer> nexts = list.get(i);
        map[i][colors.charAt(i) - 'a'] = 1;
        for (int next : nexts) {
            boolean result = dp(next, colors, list, status, map);
            if (result) {
                for (int c = 0; c < 26; c++) {
                    if (c == colors.charAt(i) - 'a') {
                        map[i][c] = map[i][c] < map[next][c] + 1 ? map[next][c] + 1 : map[i][c];
                    } else {
                        map[i][c] = map[i][c] < map[next][c] ? map[next][c] : map[i][c];
                    }
                }
            } else {
                return false;
            }
        }

        status[i] = 2;
        return true;
    }
}
