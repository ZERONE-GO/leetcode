package p0740;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int num : nums) {
            count[num] ++;
        }
        
        int prev = 0, res = count[1];
        
        for(int i =2; i < 10001; i ++) {
            int tmp = res;
            res = Math.max(count[i] * i + prev, tmp);
            prev = tmp;
        }
        
        return res;
    }
}
