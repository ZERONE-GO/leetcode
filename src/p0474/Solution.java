package p0474;

public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int[] zo = count(strs[i]);

            for (int j = m; j >= zo[0]; j--) {
                for (int k = n; k >= zo[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zo[0]][k - zo[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - '0']++;
        }
        return count;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        s.findMaxForm(strs, 5, 3);
         
    }
}
