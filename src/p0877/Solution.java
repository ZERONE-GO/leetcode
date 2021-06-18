package p0877;

import java.util.Arrays;


public class Solution {

    public boolean stoneGame(int[] piles) {
        int[] sum = new int[piles.length + 1];

        for (int i = 0; i < piles.length; i++) {
            sum[i + 1] = sum[i] + piles[i];
        }
        
        int[][] dp = new int[piles.length][piles.length];
        for(int i=0; i < piles.length; i ++) {
            Arrays.fill(dp[i], -1);
        }

        calc(dp, 0, piles.length-1, sum);
        return sum[piles.length] - dp[0][piles.length-1] < dp[0][piles.length-1];
    }
    
    private int calc(int[][] dp, int i, int j, int[] sum) {
        if(i > j) {
            return 0;
        }
        
        if(dp[i][j] == -1) {
            dp[i][j] = Math.max(sum[j+1]-sum[i]-calc(dp, i+1, j, sum), sum[j+1]-sum[i]-calc(dp, i, j -1, sum));
        }
        
        return dp[i][j];
    }

}
