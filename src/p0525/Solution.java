package p0525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count0 = 0, count1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                count1++;
            }

            if (map.containsKey(count1 - count0)) {
                if (res < i - map.get(count1 - count0)) {
                    res = i - map.get(count1 - count0);
                }
            } else {
                map.put(count1 - count0, i);
            }
        }

        return res;
    }
}
