package p0220;

import java.util.TreeSet;

public class TreeSetSolution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            long value = (long) nums[i];

            Long f = ts.floor(value);
            if (f != null && value - f <= t) {
                return true;
            }
            Long c = ts.ceiling(value);
            if (c != null && c - value <= t) {
                return true;
            }
            ts.add(value);
            if (i >= k) {
                ts.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
