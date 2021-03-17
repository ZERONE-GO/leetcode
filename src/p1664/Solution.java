package p1664;

public class Solution {

    public int waysToMakeFair(int[] nums) {
        int oddSum = 0, evenSum = 0;
        int[] sum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }

            if (i >= 2) {
                sum[i] = sum[i - 2] + nums[i];
            } else {
                sum[i] = nums[i];
            }
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int odd = 0, even = 0;
            if ((i & 1) == 1) {
                even = sum[i - 1] + oddSum - sum[i];
                odd = sum[i] - nums[i] + evenSum - sum[i - 1];
                if (even == odd) {
                    result++;
                }
            } else {
                if (i >= 1) {
                    even = sum[i] - nums[i] + oddSum - sum[i - 1];
                    odd = sum[i - 1] + evenSum - sum[i];
                } else {
                    even = oddSum;
                    odd = evenSum - sum[i];
                }
                if (even == odd) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {1,1,1};
        s.waysToMakeFair(nums);
    }

}
