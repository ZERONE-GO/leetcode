package p1785;

public class Solution {
    
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i=0; i < nums.length; i ++) {
            sum += nums[i];
        }
        
        long diff = Math.abs(sum -goal);
        if(diff % limit != 0) {
            return (int)(diff/limit) + 1;
        } else {
            return (int)(diff/limit);
        }
    }

}
