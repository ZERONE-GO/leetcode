package p0516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] map = new int[len+1][len+1];
        
        for(int i=1; i <= len; i ++) {
            for(int j=1; j <=len; j ++) {
                if(s.charAt(i-1) == s.charAt(len - j)) {
                    map[i][j] = Math.max(map[i-1][j-1]+1, Math.max(map[i-1][j], map[i][j-1]));
                } else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        return map[len][len];
    }
}
