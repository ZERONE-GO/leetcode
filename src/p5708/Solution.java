package p5708;

public class Solution {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int[] revs = new int[nums.length];
        int count = 0;
        
        for(int i =0; i < nums.length; i ++) {
            revs[i] = rev(nums[i]);
        }
        
        for(int i=0; i < nums.length; i ++) {
            for(int j=i + 1; j < nums.length; j ++) {
                if(nums[i] + revs[j] == revs[i] + nums[j]) {
                    count = (count + 1) % MOD; 
                }
            }
        }
        
        return count;
    }

    private int rev(int num) {
        int result = 0;

        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums= {42,11,1,97};
        s.countNicePairs(nums);
    }

}
