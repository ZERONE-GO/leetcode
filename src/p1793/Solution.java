package p1793;

public class Solution {
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
        for(int left = 0, right= nums.length - 1; left <= k && right >= k; ) {
            if(lstack[ll-1] < rstack[rl-1]) {
                if(value < lstack[ll-1] * (right-left + 1)) {
                    value = lstack[ll-1] * (right - left + 1);
                }
                
                if(nums[left] == lstack[ll-1]) {
                    ll --;
                }
                left ++;
            } else {
                if(value < rstack[rl-1] * (right-left + 1)) {
                    value = rstack[rl-1] * (right - left + 1);
                }
                if(nums[right] == rstack[rl-1]) {
                    rl --;
                }
                right --;
            }
        }
        return value;
    }
}
