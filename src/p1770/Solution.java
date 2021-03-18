package p1770;

import java.util.Arrays;

public class Solution {

    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] backup = new int[nums.length][nums.length];
        for(int i =0; i < nums.length; i ++) {
            Arrays.fill(backup[i], -1);
        }
        return score(nums, multipliers, backup, 0, nums.length-1, 0);
    }

    private int score(int[] nums, int[] multipliers, int[][] backup, int left, int right, int index) {
        if (index == multipliers.length) {
            return 0;
        }
        
        if(backup[left][right] == -1) {
            int ls = score(nums, multipliers, backup, left + 1, right, index + 1) + nums[left] * multipliers[index];
            int rs = score(nums, multipliers, backup, left, right - 1, index + 1) + nums[right] * multipliers[index];
            backup[left][right] =  ls > rs ? ls : rs;
        }
        return backup[left][right];
    }
}
