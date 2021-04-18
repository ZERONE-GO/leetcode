package p1685;

public class Solution {
    
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int[] abs = new int[nums.length];
        
        for(int i=1; i <= nums.length; i ++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        for(int i=0; i < nums.length; i ++) {
            abs[i] = nums[i] * i - sum[i] + sum[nums.length] - sum[i+1] - nums[i] * (nums.length -1 -i);
        }
        
        return abs;
    }

}
