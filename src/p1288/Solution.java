package p1288;

import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = 0, right = 1;
        int count = 0;
        while (right < intervals.length) {
            while (intervals[right][0] >= intervals[left][1]) {
                left++;
            }

            for (int i = left; i < right; i++) {
                if (intervals[right][1] <= intervals[i][1]) {
                    count++;
                    break;
                }
            }

            right++;
        }

        return intervals.length - count;
    }
}
