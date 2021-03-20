package p0581;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        
        if(len == 1) {
            return 0;
        }
        
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        
        maxArr[0] = nums[0];
        for(int i=1; i < len; i ++) {
            maxArr[i] = Math.max(maxArr[i-1], nums[i]);
        }
        
        minArr[len-1] = nums[len-1];
        for(int i=len-2; i >=0; i --) {
            minArr[i] = Math.min(minArr[i+1], nums[i]);
        }
        
        int start = 0;
        if(nums[start] <= minArr[start+1]) {
            start ++;
            while(start < len-1 && nums[start] >= maxArr[start - 1] && nums[start] <= minArr[start+1]) {
                start ++;
            }
        }
        int end = len - 1;
        if(nums[end] >= maxArr[end - 1]) {
            end --;
            while(end > 0 && nums[end] >= maxArr[end-1] && nums[end] <= minArr[end + 1]) {
                end --;
            }
        }
        
        
        return end>start ? end - start + 1 : 0;
    }
    
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 3, 3};
        Solution s = new Solution();
        s.findUnsortedSubarray(nums);
    }
}
