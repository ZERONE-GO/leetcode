package p0518;

import java.util.Arrays;

public class Solution {

    public int change(int amount, int[] coins) {
        if(amount == 0) {
            return 1;
        }
        int[][] res = new int[amount + 1][coins.length+1];
        for(int i=1; i <= amount; i ++) {
            Arrays.fill(res[i], -1);
        }

        calc(amount, coins.length, coins, res);

        return res[amount][coins.length];
    }

    private int calc(int amount, int c, int[] coins, int[][] res) {
        if(amount == 0) {
            return 1;
        }
        if(c == 0) {
            return 0;
        }
        if (res[amount][c] != -1) {
            return res[amount][c];
        }

        int tmp = 0, k = 0;
        while(k * coins[c-1] <= amount) {
            tmp += calc(amount- k * coins[c-1], c - 1, coins, res);
            k ++;
        }
        res[amount][c] = tmp;
        return res[amount][c];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[] {1, 2, 5}));
    }

}
