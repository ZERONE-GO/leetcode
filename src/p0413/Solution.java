package p0413;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        int prev = 0, next = 1, diff = nums[next] - nums[prev], len = 1;

        while (next < nums.length) {
            if (diff == nums[next] - nums[prev]) {
                next++;
                prev++;
                len++;
            } else {
                ans += count(len);
                len = 1;
                diff = nums[next] - nums[prev];
            }
        }

        ans += count(len);
        return ans;
    }

    private int count(int len) {
        return ((len - 1) * (len - 2)) / 2;
    }
}
