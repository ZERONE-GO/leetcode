package p0076;

public class Solution {

    public String minWindow(String s, String t) {
        int[] counts = new int[256];
        int total = t.length();

        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }
        int[] ans = new int[] { -1, -1 };
        int left = 0, right = 0, len = s.length(), res = len + 1;

        while (right < len) {

            while (right < len && total > 0) {
                if (counts[s.charAt(right)] > 0) {
                    total--;
                    counts[s.charAt(right)]--;
                } else {
                    counts[s.charAt(right)]--;
                }
                right++;
            }

            while (left <= right && total <= 0) {
                if (counts[s.charAt(left)] < 0) {
                    counts[s.charAt(left)]++;
                } else {
                    total++;
                    counts[s.charAt(left)]++;

                    if (res > right - left) {
                        res = right - left;
                        ans[0] = left;
                        ans[1] = right;
                    }
                }
                left++;
            }

        }

        if (ans[0] != -1) {
            return s.substring(ans[0], ans[1]);
        } else {
            return "";
        }
    }

}
