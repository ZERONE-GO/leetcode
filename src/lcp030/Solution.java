package lcp030;

import java.util.PriorityQueue;

public class Solution {

    public int magicTower(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int count = 0;
        long life = 1;
        long tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                queue.add(nums[i]);
            }
            life += nums[i];
            if (life <= 0) {
                int move = queue.poll();
                tail += move;
                count++;
                life -= move;
            }
        }

        return life + tail > 0 ? count : -1;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {100,100,100,-250,-60,-140,-50,-50,100,150};
        s.magicTower(nums);
    }
}
