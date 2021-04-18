package p5717;

class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                step += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }

        return step;
    }
}