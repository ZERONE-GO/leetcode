package p0516;

import java.util.Arrays;

public class Solution2 {
    
    public int longestPalindromeSubseq(String s) {
        int[][] map = new int[s.length()][s.length()];
        
        for(int i=0; i < s.length(); i ++) {
            Arrays.fill(map[i], -1);
        }
        
        return dp(s, map, 0, s.length()-1);
    }
    
    public int dp(String s, int[][] map, int left, int right) {
        if(left == right) {
            return 0;
        }
        
        if(map[left][right] == -1) {
            if(s.charAt(left) == s.charAt(right)) {
                map[left][right] = Math.max(dp(s, map, left+1, right-1) + 2, Math.max(dp(s, map, left+1, right), dp(s, map, left, right-1)));
            } else {
                map[left][right] = Math.max(dp(s, map, left+1, right), dp(s, map, left, right -1));
            }
        }
        return map[left][right];
    }

}
