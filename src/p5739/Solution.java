package p5739;

import java.util.Arrays;

public class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = nums.length - 1;
        int right = nums.length - 1;
        int sum = k;
        int count = 0;
        while (left >= 0) {
            if (sum + nums[left] >= nums[right] * (right - left + 1)) {
                sum += nums[left];
                left--;
            } else {
                sum -= nums[right];
                if (count < right - left) {
                    count = right - left;
                }
                right--;
            }
        }
        if (count < right+1) {
            count = right+1;
        }

        return count;
    }
    
    public static void main(String args[]) {
        int[] nums = {3, 9 ,6};
        Solution s = new Solution();
        s.maxFrequency(nums, 2);
    }

}
