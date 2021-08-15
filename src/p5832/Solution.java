package p5832;

import java.util.Arrays;

public class Solution {
    
    public int[] rearrangeArray(int[] nums) {
        if (nums.length < 3) {
            return nums;
        }

        Arrays.sort(nums);

        int[] range = new int[nums.length];
        int middle = (nums.length & 1) == 1 ? (nums.length >> 1) + 1 : (nums.length >> 1);
        int left = 0;
        int i = 0;
        while (i < nums.length) {
            range[i] = nums[left];
            left++;
            if (i < nums.length) {
                nums[i] = nums[middle];
                middle++;
            }
        }

        return range;
    }

}
