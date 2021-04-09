package p0154;

public class Solution {
    
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right) {
            int middle = left + (right - left) / 2;
            
            if(nums[middle] == nums[left] && nums[middle] == nums[right]) {
                left ++;
                right --;
            } else if(nums[middle] <= nums[right]) {
                right = middle;
            } else {
               left = middle + 1;
            }
        }

        return nums[right];
    }

}
