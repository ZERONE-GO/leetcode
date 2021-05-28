package p0477;

// time out
public class Solution2 {

    public int totalHammingDistance(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += calcHammingDistance(nums[i], nums[j]);
            }
        }

        return ans;
    }

    private int calcHammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >>> 1;
        }
        return count;
    }
}
