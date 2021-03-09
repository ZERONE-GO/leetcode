package p0283;

public class Solution {
    
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        
        while(right < nums.length) {
            if(nums[right] == 0) {
                right ++;
            } else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left ++;
                right ++;
            }
        }
    }

}
