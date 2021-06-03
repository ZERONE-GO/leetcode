package p0523;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remaind = 0;
        for (int i = 0; i < nums.length; i++) {
            remaind = (remaind + nums[i])%k;

            if (map.containsKey(remaind)) {
                if (i - map.get(remaind) >= 2) {
                    return true;
                }
            } else {
                map.put(remaind, i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = { 5, 0, 0, 0 };
        int k = 3;
        s.checkSubarraySum(nums, k);
    }

}
