package p1822;

public class Solution {
    
    public int arraySign(int[] nums) {
        int result = 1;
        for(int i=0; i < nums.length; i ++) {
            if(nums[i] < 0) {
                result = -result;
            } else if(nums[i] == 0) {
                return 0;
            }
        }
        return result;
    }

}
