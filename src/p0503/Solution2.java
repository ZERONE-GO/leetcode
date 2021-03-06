package p0503;

import java.util.Arrays;

public class Solution2 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        int[] stack = new int[len * 2];
        int sl = 0;

        for (int i = 0; i < len; i++) {
            if (sl == 0) {
                stack[sl] = i;
                sl++;
            } else {
                while (sl > 0 && nums[stack[sl - 1]] < nums[i]) {
                    res[stack[sl - 1]] = nums[i];
                    sl--;
                }
                stack[sl] = i;
                sl++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (sl == 0) {
                stack[sl] = i;
                sl++;
            } else {
                while (sl > 0 && nums[stack[sl - 1]] < nums[i]) {
                    res[stack[sl - 1]] = nums[i];
                    sl--;
                }
                stack[sl] = i;
                sl++;
            }
        }

        return res;
    }
}
