package p0022;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] p = new char[2 * n];
        pushParenthesis(n, p, 0, 0, result);
        return result;
    }

    private void pushParenthesis(int n, char[] p, int left, int len, List<String> result) {
        if (n == 0 && left == 0) {
            result.add(new String(p));
        } else if (n > 0) {
            p[len] = '(';
            left = left + 1;
            len = len + 1;
            pushParenthesis(n - 1, p, left, len, result);
            while (left > 0) {
                p[len++] = ')';
                left = left - 1;
                pushParenthesis(n - 1, p, left, len, result);
            }
        }
    }
}
