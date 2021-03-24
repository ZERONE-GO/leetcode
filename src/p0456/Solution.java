package p0456;

public class Solution {
    
    public boolean find132pattern(int[] nums) {
        int[] iarr = new int[nums.length];
        int[] karr = new int[nums.length];
        int kl = 0;
        iarr[0] = nums[0];
        for(int i=1; i < nums.length; i ++) {
            iarr[i] = iarr[i-1] < nums[i] ? iarr[i-1] : nums[i];
        }

        
        for(int i=nums.length-1; i >=0; i --) {
            if(nums[i] > iarr[i]) {
                while(kl > 0 && karr[kl-1] < iarr[i]) {
                    kl --;
                }
                
                if(kl >0 && nums[i] > karr[kl -1]) {
                    return true;
                }
                
                karr[kl] = nums[i];
                kl ++;
            }
        }
        return false;
    }

}
