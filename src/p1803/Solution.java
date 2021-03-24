package p1803;

public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high) {
                    count++;
                }
            }
        }

        return count;
    }

}
