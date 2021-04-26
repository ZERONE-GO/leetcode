package p5741;

import java.util.Arrays;

public class Solution {

    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> {
            return a[0] - b[0];
        });

        int p = 1, ph = 0;
        for (int i = 0; i < restrictions.length; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i][0] - p + ph);
            p = restrictions[i][0];
            ph = restrictions[i][1];
        }

        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], p - restrictions[i][0] + ph);
            p = restrictions[i][0];
            ph = restrictions[i][1];
        }

        int max = 0;
        p = 1;
        ph = 0;
        for (int i = 0; i < restrictions.length; i++) {
            int x = (restrictions[i][0] + restrictions[i][1] + p - ph) / 2;
            int height = x - p + ph;
            if (height > max) {
                max = height;
            }
            p = restrictions[i][0];
            ph = restrictions[i][1];
        }
        ph = n - p + ph;
        if (ph > max) {
            max = ph;
        }

        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] restrictions = { { 8, 5 }, { 9, 0 }, { 6, 2 }, { 4, 0 }, { 3, 2 }, { 10, 0 }, { 5, 3 }, { 7, 3 },
                { 2, 4 } };
        System.out.println(s.maxBuilding(10, restrictions));
    }

}
