package lcp019;

public class Solution {

    public int minimumOperations(String leaves) {
        int l = leaves.length();
        int[][] map = new int[l][3];

        map[0][0] = isRed(leaves, 0) ? 0 : 1;
        map[0][1] = l;
        map[0][2] = l;
        for (int i = 1; i < l; i++) {
            boolean isRed = isRed(leaves, i);
            map[i][0] = map[i - 1][0] + (isRed ? 0 : 1);
            map[i][1] = Math.min(map[i-1][0], map[i-1][1]) + (isRed ? 1 : 0);
            map[i][2] = Math.min(map[i-1][1], map[i-1][2]) + (isRed ? 0 : 1);
        }

        return map[l-1][2];
    }

    private boolean isRed(String leaves, int i) {
        return leaves.charAt(i) == 'r';
    }
}
