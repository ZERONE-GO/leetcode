package p0493;

public class Solution {

    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] > nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }

}
