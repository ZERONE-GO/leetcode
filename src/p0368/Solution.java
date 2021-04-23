package p0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        Arrays.sort(nums);

        int[] max = new int[nums.length];
        max[nums.length - 1] = 1;
        int largest = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] % nums[i] == 0 && max[i] < max[j] + 1 ) {
                    max[i] = max[j] + 1;
                    if(largest < max[i]) {
                        largest = max[i];
                    }
                }
            }
        }
        
        int cur = 1;
        for(int i=0; i < nums.length;i ++) {
            if(max[i] == largest && nums[i] % cur == 0) {
                res.add(nums[i]);
                cur = nums[i];
                largest --;
            }
        }

        return res;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {1, 2, 4, 6, 12, 24, 48,8};
        List<Integer> res = s.largestDivisibleSubset(nums);
        for(Integer n : res) {
            System.out.print(n + ",");
        }
    }

}
