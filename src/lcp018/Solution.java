package lcp018;

import java.util.Arrays;

public class Solution {

    private static final int MOD = 1000000007;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int ans = 0;
        Arrays.sort(drinks);

        for(int i=0; i < staple.length; i ++) {
            ans = (ans + binarySearch(drinks, x - staple[i])) % MOD;
        }
        
        return ans;
    }

    private int binarySearch(int[] drinks, int v) {
        int left = 0, right = drinks.length;

        while (left < right) {
            int middle = (left + right) / 2;

            if (drinks[middle] <= v) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

}
