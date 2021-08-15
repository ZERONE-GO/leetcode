package p0446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;

        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault((long)nums[i], new ArrayList<Integer>());
            list.add(i);
            map.put((long)nums[i], list);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long diff = (long)nums[j] - (long)nums[i];
                ans += countArithmetics(j, nums[j] + diff, diff, map);
            }
        }

        return ans;
    }

    private int countArithmetics(int index, long value, long diff, Map<Long, List<Integer>> map) {
        int res = 0;

        List<Integer> list = map.getOrDefault(value, new ArrayList<Integer>());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > index) {
                res += countArithmetics(list.get(i), value + diff, diff, map) + 1;
            }
        }

        return res;
    }
    
    public static void main(String args[]) {
        int[] nums = {1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution s = new Solution();
        System.out.println(s.numberOfArithmeticSlices(nums));
    }
}