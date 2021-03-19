package p1771;

public class Solution {
    public int longestPalindrome(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] map = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i <= l2; i++) {
            map[0][0] = 1;
        }
        map[0][0] = 0;

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int v = word1.charAt(l1 - i - 1) == word2.charAt(j) ? map[i][j] + 2 : map[i][j];
                map[i + 1][j + 1] = Math.max(map[i][j + 1], Math.max(map[i + 1][j], v));
            }
        }
        

        return map[l1][l2] == 1 ? 0 : map[l1][l2];
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("ceebeddc", "d"));
    }
}
