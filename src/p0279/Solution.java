package p0279;

import java.util.Arrays;

public class Solution {
    
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        calc(dp, n);
        return dp[n];
    }
    
    private int calc(int[] dp, int n) {
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int tmp = Integer.MAX_VALUE;
        
        for(int i = (int)Math.sqrt(n); i >= 1; i --) {
            tmp = Math.min(tmp, calc(dp, n-i*i) + 1);
        }
        dp[n] = tmp;
        return dp[n];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution(); 
        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(13));
        System.out.println(s.numSquares(1));
        System.out.println(s.numSquares(9999));
    }

    
}
