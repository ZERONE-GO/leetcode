package p5780;

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int l = 0;
        while (l < nums.length - 1 && nums[l] < nums[l + 1]) {
            l++;
        }

        if (l == nums.length - 1) {
            return true;
        }
        int nxt = l + 1;
        if ((l >= 1 && nums[nxt] > nums[l - 1]) || (l == 0)) {

        } else if ((nxt < nums.length - 1 && nums[l] < nums[nxt + 1])) {
            nxt = nxt + 1;
        } else if (nxt == nums.length - 1) {
            return true;
        } else {
            return false;
        }

        while (nxt < nums.length - 1 && nums[nxt] < nums[nxt + 1]) {
            nxt++;
        }

        if (nxt == nums.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
