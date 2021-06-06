package p1877;

import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            if (ans < nums[left] + nums[right]) {
                ans = nums[left] + nums[right];
            }
        }
        return ans;
    }
}
