package p5786;

public class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (isSubSequence(s, p, removable, middle + 1)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right;
    }

    private boolean isSubSequence(String s, String p, int[] removable, int k) {
        boolean[] color = new boolean[s.length()];

        for (int i = 0; i < k; i++) {
            color[removable[i]] = true;
        }

        int pl = 0, sl = 0;

        while (pl < p.length() && sl < s.length()) {
            if (color[sl]) {
                sl++;
            } else if (p.charAt(pl) == s.charAt(sl)) {
                pl++;
                sl++;
            } else {
                sl++;
            }
        }
        return pl == p.length();
    }

}
