package p5722;

public class Solution {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
                if (k == 0) {
                    break;
                }
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
