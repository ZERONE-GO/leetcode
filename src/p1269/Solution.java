package p1269;

class Solution {

    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int len = Math.min(steps + 1, arrLen);
        int[][] dp = new int[steps + 1][len + 2];

        dp[0][1] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 1; j <= len; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 1][j]) % MOD + dp[i - 1][j + 1]) % MOD;
            }
        }

        return dp[steps][1];
    }
}