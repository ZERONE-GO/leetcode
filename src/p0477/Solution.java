package p0477;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] count = new int[32];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            getBit(nums[i], count);
        }

        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            ans += count[i] * (len - count[i]);
        }

        return ans;
    }

    private void getBit(int x, int[] count) {
        int l = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count[l]++;
            }
            l++;
            x = x >>> 1;
        }
    }

}
