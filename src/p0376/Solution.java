package p0376;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] wiggle = new int[nums.length];
        int wl = 0;
        wiggle[wl++] = nums[0];

        int move = 1;
        while (move < nums.length && nums[move] == wiggle[0]) {
            move++;
        }

        if (move < nums.length) {
            wiggle[wl++] = nums[move];
            for (move = move + 1; move < nums.length; move++) {
                if (nums[move] == wiggle[wl - 1]) {
                    continue;
                }

                boolean isUp = wiggle[wl - 1] > wiggle[wl - 2];
                boolean isDown = nums[move] < wiggle[wl - 1];
                if ((isUp && isDown) || (!isUp && !isDown)) {
                    wiggle[wl++] = nums[move];
                } else {
                    wiggle[wl - 1] = nums[move];
                }
            }
        }

        return wl;
    }

    public static void main(String args[]) {
        int[] nums = { 33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72,
                9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78,
                43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93,
                98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15 };
        Solution s = new Solution();
        System.out.println(s.wiggleMaxLength(nums));
    }

}
