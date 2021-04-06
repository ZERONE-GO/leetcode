package p0410;

public class Solution2 {
    public int splitArray(int[] nums, int m) {
        int left = nums[0], right = 0;
        
        for(int i=0; i < nums.length; i ++) {
            right = right + nums[i];
        }
        right ++;
        while(left < right) {
            int middle = (left + right - 1) / 2;
            if(count(nums, middle) > m) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }
    
    private int count(int[] nums, int value) {
        int count = 1, sum = 0;
        for(int i=0; i < nums.length; i ++) {
            if(nums[i] > value) {
                return Integer.MAX_VALUE;
            }
            if(sum + nums[i] <= value) {
                sum = sum + nums[i];
            } else {
                count ++;
                sum = nums[i];
            }
        }
        return count;
    }
}
