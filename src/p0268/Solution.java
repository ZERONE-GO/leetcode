package p0268;

public class Solution {
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i < n; i ++) {
            while(nums[i] != i && nums[i] < n) {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        
        for(int i =0; i < n; i ++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return n;
    }

}
