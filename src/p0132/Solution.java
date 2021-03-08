package p0132;

import java.util.Arrays;

public class Solution {

    
    public int minCut(String s) {
        int[][] map = new int[s.length()][s.length()];
        for(int i=0; i < s.length(); i ++) {
            Arrays.fill(map[i], -1);
        }
        
        return palindromic(s, 0, s.length() - 1, map);
    }
    
    private int palindromic(String str, int s, int e, int[][] map) {
        if(s == e || isPalindromic(str, s, e)) {
            return 0;
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=s; i < e; i ++) {
            if(isPalindromic(str, s, i)) {
                if(map[i+1][e] == -1) {
                    int right = palindromic(str, i+1, e, map);
                    map[i+1][e] = right;
                }
                result = result > map[i+1][e] + 1 ? map[i+1][e] + 1 : result;
            }
        }
        return result;
    }
    
    private boolean isPalindromic(String str, int s, int e) {
        while (s <= e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.minCut("aabc"));
    }
}
