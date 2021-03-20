package p5712;

import java.util.Arrays;

public class Solution {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int N = 0;

        int l = 0;
        while (l < coins.length ) {
            int v = N + 1 - coins[l];
            if(v >= 0 && v <= N) {
                N = N + coins[l];
            } else {
                break;
            }
            l++;
        }
        return N+1;
    }

}
