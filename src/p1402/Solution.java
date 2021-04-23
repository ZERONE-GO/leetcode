package p1402;

import java.util.Arrays;

public class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        int[][] map = new int[satisfaction.length + 1][satisfaction.length + 1];

        Arrays.sort(satisfaction);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= satisfaction.length; i++) {
            for (int j = 1; j <= i; j++) {
                map[i][j] = map[i - 1][j - 1] + satisfaction[i - 1] * j;
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        return max;
    }
}
