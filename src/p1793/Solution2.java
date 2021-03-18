package p1793;

public class Solution2 {
    public int maximumScore(int[] nums, int k) {
        int[] lstack = new int[k + 1];
        int ll = 0;
        int[] rstack = new int[nums.length - k + 1];
        int rl = 0;

        for (int i = k; i >= 0; i--) {
            if (ll == 0 || lstack[ll - 1] >= nums[i]) {
                lstack[ll] = nums[i];
                ll++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (rl == 0 || rstack[rl - 1] >= nums[i]) {
                rstack[rl] = nums[i];
                rl++;
            }
        }
        int value = Integer.MIN_VALUE;
        for(int left = 0; left <= k; left ++) {
            int tmp = rl;
            for(int right=nums.length-1; right >= k; right --) {
                int min = Math.min(lstack[ll-1], rstack[tmp-1]);
                
                if(value < min * (right-left + 1)) {
                    value = min * (right - left + 1);
                }
                if(nums[right] == rstack[tmp-1]) {
                    tmp --;
                }
            }
            if(nums[left] == lstack[ll-1]) {
                ll --;
            }
        }
        return value;
    }
    
    public static void main(String args[]) {
        int[] nums = {1,4,3,7,4,5};
        Solution2 s = new Solution2();
        s.maximumScore(nums, 3);
    }
}
