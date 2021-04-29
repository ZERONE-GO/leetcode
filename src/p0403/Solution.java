package p0403;

import java.util.Arrays;

public class Solution {
    public boolean canCross(int[] stones) {
        boolean[][] map = new boolean[stones.length][stones.length+1];
        map[0][0] = true;
        for (int i = 0; i < stones.length - 1; i++) {
            for (int k = 1; k <= i + 1; k++) {
                if (map[i][k]||map[i][k-1]||map[i][k+1]) {
                    int j = Arrays.binarySearch(stones, stones[i] + k);
                    if (j >= 0) {
                        map[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i <= stones.length; i++) {
            if (map[stones.length - 1][i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int[] stones = {0,1,2,3,4,8,9,11};
        Solution s = new Solution();
        System.out.println(s.canCross(stones));

    }
}
