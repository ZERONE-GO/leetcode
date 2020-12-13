package p0034;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int index = binarySearch(nums, target);
        if (index < 0) {
            result[0] = -1;
            result[1] = -1;
        } else {
            int left = index;
            while (left - 1 >= 0 && nums[left - 1] == target) {
                left--;
            }
            int right = index;
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            result[0] = left;
            result[1] = right;
        }
        return result;
    }
    
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle = nums.length / 2;
        
        while(left < right) {
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return -(middle + 1);
    }

}
