package p0220;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> bucket = new HashMap<Long, Long>();

        for (int i = 0; i < nums.length; i++) {
            long key = getKey(nums[i], t + 1);

            if (bucket.containsKey(key)) {
                return true;
            }

            if (bucket.containsKey(key - 1)) {
                if (nums[i] - bucket.get(key - 1) <= t) {
                    return true;
                }
            }

            if (bucket.containsKey(key + 1)) {
                if (bucket.get(key + 1) - nums[i] <= t) {
                    return true;
                }
            }
            bucket.put(key, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getKey(nums[i - k], t + 1));
            }
        }

        return false;
    }

    private long getKey(long value, long size) {
        if (value >= 0) {
            return value / size;
        } else {
            return (value + 1) / size - 1;
        }
    }
    
    public static void main(String args[]) {
        int[] nums = {1,5,9, 1, 5, 9};
        Solution s = new Solution();
        boolean r = s.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(r);
    }

}
