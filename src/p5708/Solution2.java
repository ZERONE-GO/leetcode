package p5708;

import java.util.Arrays;

public class Solution2 {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int[] revs = new int[nums.length];
        long count = 0;
        
        for(int i =0; i < nums.length; i ++) {
            revs[i] = nums[i] - rev(nums[i]);
        }
        
        Arrays.sort(revs);
        long p = 1;
        for(int i=1; i < revs.length; i ++) {
            if(revs[i] == revs[i-1]) {
                p ++;
            } else {
                long v = p * (p-1) / 2;
                v= v % MOD;
                count = (count + v) % MOD;
                p = 1;
            }
        }
        long v = p * (p-1) / 2;
        v= v % MOD;
        count = (count + v) % MOD;
        
        return (int)count;
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
        Solution2 s = new Solution2();
        int[] nums= {42,11,1,97};
        s.countNicePairs(nums);
    }
}
