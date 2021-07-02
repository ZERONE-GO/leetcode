package p1787;

import java.util.Arrays;

public class Solution2 {

    public int minChanges(int[] nums, int k) {
        int[][] counts = new int[k][1025];

        for (int i = 0; i < nums.length; i++) {
            counts[i % k][nums[i]]++;
            counts[i % k][1024]++;
        }
        int[][] dp = new int[k][1024];

        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], nums.length);
        }

        for (int i = 0; i < 1024; i++) {
            dp[0][i] = counts[0][1024] - counts[0][i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < 1024; j++) {
                for (int l = 0; l < 1024; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ l] + counts[i][1024] - counts[i][l]);
                }
            }
        }

        return dp[k - 1][0];
    }
}
