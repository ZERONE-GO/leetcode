package lcp017;

public class Solution {

    public int calculate(String s) {
        int x = 1, y = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = calc(x, y);
            } else {
                y = calc(y, x);
            }
        }

        return x + y;
    }

    private int calc(int a, int b) {
        return 2 * a + b;
    }
}
