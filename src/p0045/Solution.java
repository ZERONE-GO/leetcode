package p0045;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int s = 0, e = nums[0], step = 1;

        while (e < nums.length - 1) {
            int next = e;
            while (s <= e) {
                if (next < nums[s] + s) {
                    next = nums[s] + s;
                }
                s++;
            }
            e = next;
            step++;
        }

        return step;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };

        s.jump(nums);
    }
}
