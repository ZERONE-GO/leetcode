package p1768;

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int l1 = 0, l2 = 0;
        while (l1 < word1.length() && l2 < word2.length()) {
            sb.append(word1.charAt(l1));
            sb.append(word2.charAt(l2));
            l1++;
            l2++;
        }

        while (l1 < word1.length()) {
            sb.append(word1.charAt(l1));
            l1++;
        }

        while (l2 < word2.length()) {
            sb.append(word2.charAt(l2));
            l2++;
        }

        return sb.toString();
    }
}
