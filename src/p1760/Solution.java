package p1760;

public class Solution {
    
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, ans = 0, right = 1;
        
        for(int i=0;i < nums.length; i++) {
            if(nums[i] > right) {
                right = nums[i];
            }
        }
        
        while(left <= right) {
            int mid = (left + right) /2;
            
            long ops = 0; 
            for(int i=0; i < nums.length; i ++) {
                ops += (nums[i]-1) / mid;
            }
            
            if(ops <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
