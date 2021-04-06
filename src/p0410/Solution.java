package p0410;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i=1; i <= nums.length; i ++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int[][] backup = new int[m+1][nums.length+1];
        for(int i=0; i <= m; i ++) {
            for(int j=0; j <= nums.length; j ++) {
                backup[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return dp(sum, backup, m, 0);
    }

    private int dp(int[] sum, int[][] backup, int m, int i) {
        if(m == 1) {
            return sum[sum.length] - sum[i]; 
        }
        
        for(int j = i; j < sum.length - m + 1; j ++) {
            int value = sum[j+1] - sum[i];
            if(backup[m-1][j+1] == Integer.MAX_VALUE) {
                backup[m-1][j+1] = dp(sum, backup, m-1, j+1);
            }
            value = Math.max(value, backup[m-1][j+1]);
            backup[m][i] = Math.min(backup[m][i], value);
        }
        return backup[m][i];
    }
}
