package p0494;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] count = new int[nums.length + 1][2001];
        count[0][1000] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2000; j++) {
                if (j - nums[i - 1] >= 0) {
                    count[i][j] += count[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2000) {
                    count[i][j] += count[i - 1][j + nums[i - 1]];
                }
            }
        }
        return count[nums.length][target + 1000];
    }
}