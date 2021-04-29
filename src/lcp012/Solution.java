package lcp012;

public class Solution {

    public int minTime(int[] time, int m) {
        int left = 0, right = 0;

        for (int i = 0; i < time.length; i++) {
            right += time[i];
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (count(time, middle) > m) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private int count(int[] time, int value) {
        int sum = 0, max = 0, count = 1;
        for (int i = 0; i < time.length; i++) {
            max = max > time[i] ? max : time[i];
            if (sum + time[i] - max > value) {
                count++;
                sum = time[i];
                max = time[i];
            } else {
                sum = sum + time[i];
            }
        }
        return count;
    }
}
