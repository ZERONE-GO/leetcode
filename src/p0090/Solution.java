package p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        
        
        int left = 0, right = 1;
        while(right < nums.length) {
            if(nums[right] == nums[left]) {
                count[left] ++;
            } else {
                left ++;
                nums[left] = nums[right];
            }
            right ++;
        }
        int[] selected = new int[left+1];
        subsets(result, nums, count, selected, left);
        
        return result;
    }
    
    private void subsets(List<List<Integer>> result, int[] nums, int[] count,  int[] selected, int size) {
        if(size < 0) {
            List<Integer> subset = new ArrayList<Integer>();
            
            for(int i=0; i < selected.length; i ++) {
                for(int j=0; j < selected[i]; j ++) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
            return;
        }
        
        for(int i=0; i<= count[size]; i ++) {
            selected[size] = i;
            subsets(result, nums, count, selected, size - 1);
        }
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {1,2,2};
        s.subsetsWithDup(nums);
    }

}
