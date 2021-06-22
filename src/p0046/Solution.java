package p0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        permutation(nums, 0, nums.length);
        return res;
    }

    private void permutation(int[] nums, int s, int e) {
        if(s == e) {
            List<Integer> r = new ArrayList<>();
            for(int num : nums) {
                r.add(num);
            }
            res.add(r);
            return;
        }

        for(int i=s; i < e; i ++) {
            swap(nums, i, s);
            permutation(nums, s+1, e);
            swap(nums, i, s);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}