package game001;

import java.util.Arrays;

public class Solution {

    private static final int MOD = 1000000007;

    public int purchasePlans(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + right - left) % MOD;
                left++;
            }
        }

        return count;
    }
}
