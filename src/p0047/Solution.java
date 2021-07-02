package p0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        res.add(toList(nums));
        while (nextPermutation(nums)) {
            res.add(toList(nums));
        }

        return res;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> r = new ArrayList<Integer>(nums.length);
        for (int num : nums) {
            r.add(num);
        }
        return r;
    }

    private boolean nextPermutation(int[] nums) {
        int nxt = nums.length - 2;
        while (nxt >= 0 && nums[nxt] >= nums[nxt + 1]) {
            nxt--;
        }

        if (nxt < 0) {
            return false;
        }

        int i = nxt + 1, v = nxt + 1;
        while (i < nums.length) {
            if (nums[i] > nums[nxt] && nums[i] < nums[v]) {
                v = i;
            }
            i++;
        }

        swap(nums, nxt, v);
        Arrays.sort(nums, nxt + 1, nums.length);

        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String args[]) {
        int[] nums = { 2, 1, 1 };
        Solution s = new Solution();
        s.permuteUnique(nums);
    }
}
