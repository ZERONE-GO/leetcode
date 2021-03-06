package p0503;

public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int j = (i + 1) % len;
            result[i] = -1;
            while (j != i) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                }
                j = (j + 1) % len;
            }
        }

        return result;
    }

}
