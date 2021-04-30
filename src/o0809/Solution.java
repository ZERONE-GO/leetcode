package o0809;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        char[] ph = new char[2 * n];
        generate(n, 0, 0, ph, 0);
        return ans;
    }

    private void generate(int n, int left, int right, char[] ph, int pl) {
        if (left == n && right == n) {
            ans.add(String.valueOf(ph));
            return;
        }

        if (left < n) {
            ph[pl] = '(';
            generate(n, left + 1, right, ph, pl + 1);
        }
        if (left > right) {
            ph[pl] = ')';
            generate(n, left, right + 1, ph, pl + 1);
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        List<String> res = s.generateParenthesis(3);
        for (String r : res) {
            System.out.println(r);
        }
    }
}
