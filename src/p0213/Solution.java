package p0213;

import java.util.Arrays;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] r = new int[nums.length];
        r[0] = nums[0];
        r[1] = nums[0];

        for (int i = 2; i < nums.length - 1; i++) {
            r[i] = Math.max(r[i - 1], r[i - 2] + nums[i]);
        }
        int r1 = r[nums.length - 2];
        Arrays.fill(r, 0);

        r[0] = 0;
        r[1] = nums[1];
        for (int i = 0; i < nums.length; i++) {
            r[i] = Math.max(r[i - 1], r[i - 2] + nums[i]);
        }
        int r2 = r[nums.length - 1];
        return r1 < r2 ? r2 : r1;
    }

}
