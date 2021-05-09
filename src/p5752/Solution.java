package p5752;

import java.util.Stack;

public class Solution {
    public int maxSumMinProduct(int[] nums) {
        long[] sum = new long[nums.length + 1];
        int[] prev = new int[nums.length];
        int[] nxt = new int[nums.length];

        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.add(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            nxt[i] = stack.isEmpty() ? nums.length + 1 : stack.peek() + 1;
            stack.add(i);
        }

        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            long value = (long) nums[i] * (sum[nxt[i] - 1] - sum[prev[i]]);
            if (max < value) {
                max = value;
            }
        }

        return (int) (max % 1000000007);
    }

    public static void main(String args[]) {
        int[] nums = { 1, 2, 3, 2 };
        Solution s = new Solution();
        System.out.println(s.maxSumMinProduct(nums));
    }
}
