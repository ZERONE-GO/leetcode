package p1155;

public class Solution {
    
    private static final int MOD = 1000000007;
    
    public int numRollsToTarget(int d, int f, int target) {
        int[] count = new int[target+1];
        count[0] = 1;
        
        for(int i=1; i <= d; i ++) {
            for(int j= Math.min(f * i, target); j >= i; j --) {
                count[j] = 0;
                for(int k=f; k>=1; k --) {
                    if(j - k >= 0) {
                        count[j] = (count[j] + count[j-k]) % MOD;
                    }
                }
            }
            for(int j=0; j < i; j ++) {
                count[j] = 0;
            }
        }
        
        return count[target];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.numRollsToTarget(1, 6, 3));
        System.out.println(s.numRollsToTarget(2, 6, 7));
        System.out.println(s.numRollsToTarget(2, 5, 10));
        System.out.println(s.numRollsToTarget(1, 2, 3));
        System.out.println(s.numRollsToTarget(30, 30, 500));
    }

}
