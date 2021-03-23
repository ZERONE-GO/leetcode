package p5709;

public class Solution {

    public int maxAscendingSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        int result = sum[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum[i] = sum[i - 1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
            if (result < sum[i]) {
                result = sum[i];
            }
        }
        return result;
    }

}
