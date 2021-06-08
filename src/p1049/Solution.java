package p1049;

public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        boolean[] mark = new boolean[sum + 1];
        mark[0] = true;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum; j >= stones[i]; j--) {
                if(mark[j-stones[i]]) {
                    mark[j] = true;
                    int value = Math.abs(2 * j - sum);
                    if(value < res) {
                        res = value;
                    }
                }
            }
        }
        return res;
    }
}
