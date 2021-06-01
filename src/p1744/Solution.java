package p1744;

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length + 1];

        for (int i = 0; i < candiesCount.length; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long left = queries[i][1] + 1;
            long right = left * queries[i][2];

            ans[i] = (right > sum[queries[i][0]] && left <= sum[queries[i][0] + 1]);
        }

        return ans;
    }
}