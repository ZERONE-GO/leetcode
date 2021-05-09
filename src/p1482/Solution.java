package p1482;

public class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE, right = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            left = left < bloomDay[i] ? left : bloomDay[i];
            right = right > bloomDay[i] ? right : bloomDay[i];
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (check(bloomDay, k, middle) < m) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return check(bloomDay, k, left) >= m ? left : -1;
    }

    private int check(int[] bloomDay, int k, int day) {
        int m = 0;

        int l = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                l++;
                if (l >= k) {
                    m++;
                    l = 0;
                }
            } else {
                l = 0;
            }
        }
        return m;
    }
}
