package p5719;

public class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answers = new int[nums.length];

        int MAX = (1 << (maximumBit)) - 1;
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR = XOR ^ nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answers[i] = (~XOR) & MAX;
            XOR = XOR ^ nums[nums.length - 1 - i];
        }

        return answers;
    }
    
    public static void main(String args[]) {
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;
        
        Solution s = new Solution();
        s.getMaximumXor(nums, maximumBit);
    }

}
