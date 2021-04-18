package p0087;

public class Solution {

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int[][][] map = new int[len][len][len+1];
        return scramble(s1, s2, 0, 0, len, map);
    }

    private boolean scramble(String s1, String s2, int i1, int i2, int len, int[][][] map) {
        if (map[i1][i2][len] != 0) {
            return map[i1][i2][len] == 1;
        }

        if (equals(s1, s2, i1, i2, len)) {
            map[i1][i2][len] = 1;
            return true;
        }
        
        if(!similar(s1, s2, i1, i2, len)) {
            map[i1][i2][len] = -1;
            return false;
        }
        
        for(int i=0; i < len-1; i ++) {
            if(scramble(s1, s2, i1, i2, i+1, map) && scramble(s1, s2, i1 + i + 1, i2 + i + 1, len -i -1, map)) {
                map[i1][i2][len] = 1;
                return true;
            }
            if(scramble(s1, s2, i1, i2+len-i-1, i+1, map) && scramble(s1, s2, i1 + i + 1, i2, len -i -1, map)) {
                map[i1][i2][len] = 1;
                return true;
            }
        }
        map[i1][i2][len] = -1;
        return false;
    }

    private boolean equals(String s1, String s2, int i1, int i2, int len) {
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i1 + i) != s2.charAt(i2 + i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean similar(String s1, String s2, int i1, int i2, int len) {
        int[] c = new int[26];
        for(int i=0; i < len; i ++) {
            c[s1.charAt(i1+i) - 'a'] ++;
        }
        
        for(int i=0; i < len; i ++) {
            if(c[s2.charAt(i2+i) - 'a'] > 0) {
                c[s2.charAt(i2+i) - 'a'] --;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.isScramble("abcde", "caebd"));
    }

}
