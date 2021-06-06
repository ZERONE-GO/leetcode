package p5777;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if(nums[i] > stack.peek()) {
                stack.push(nums[i]);
            }
        }
        int count = 0;
        for(int i=nums.length - 1; i >=0; i --) {
            if(!stack.isEmpty() && nums[i] < stack.peek()) {
                stack.pop();
            }
            count += stack.size(); 
        }
        return count;
    }
}