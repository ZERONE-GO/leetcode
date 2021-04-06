package p0080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int prev = 1, next = 1;
        int count = 1;

        while(next < nums.length) {
            if(nums[next] == nums[prev-1]) {
                if(count < 2) {
                    nums[prev] = nums[next];
                    prev ++;
                }
                count ++;
            } else {
                nums[prev] = nums[next];
                count = 1;
                prev ++;
            }
            next ++;
        }
        
        return prev;
    }

}
