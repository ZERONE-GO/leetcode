package p0746;

public class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2) {
            return 0;
        }
        
        int paya = cost[0], payb = cost[1];
        
        for(int i = 2; i < cost.length; i ++) {
            int tmp = Math.min(paya, payb) + cost[i];
            paya = payb;
            payb = tmp;
        }
        return Math.min(paya, payb);
    }

}
