package p0377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] cn = new int[target + 1];
        cn[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    cn[i] += cn[i - nums[j]];
                } 
            }
        }

        return cn[target];
    }
}
