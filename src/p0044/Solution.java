package p0044;

public class Solution {

    public boolean isMatch(String s, String p) {
        boolean[][] map = new boolean[s.length() + 1][p.length() + 1];
        map[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            map[0][j] = map[0][j-1] && p.charAt(j-1) == '*';
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?') {
                    map[i][j] = map[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    map[i][j] = map[i - 1][j - 1] || map[i - 1][j] || map[i][j-1];
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1)) {
                        map[i][j] = map[i - 1][j - 1];
                    } else {
                        map[i][j] = false;
                    }
                }
            }
        }

        return map[s.length()][p.length()];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.isMatch("abcabczzzde", 
                "*abc???de*"));
    }

}
