package p0879;

import java.util.Arrays;

public class Solution {
    private final static int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sum = 0;
        for (int i = 0; i < profit.length; i++) {
            sum += profit[i];
        }

        int[][] dp = new int[sum + 1][n + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < group.length; i++) {
            for (int j = n; j >= group[i]; j--) {
                for (int k = sum; k >= profit[i]; k--) {
                    dp[k][j] = (dp[k][j] + dp[k - profit[i]][j - group[i]]) % MOD;
                }
            }
        }

        int res = 0;
        for (int i = minProfit; i <= sum; i++) {
            res = (res + dp[i][n]) % MOD;
        }

        return res;
    }

}
