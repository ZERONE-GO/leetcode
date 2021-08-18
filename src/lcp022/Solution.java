package lcp022;

public class Solution {

    public int paintingPlan(int n, int k) {
        if(k == n*n) {
            return 1;
        }
        
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r * n + c * n - r * c == k) {
                    res = res + cnk(n, r) * cnk(n, c);
                }
            }
        }

        return res;
    }

    private int cnk(int n, int k) {
        int res = 1;

        for (int i = 0; i < k; i++) {
            res = res * (n - i);
        }

        for (int i = 1; i <= k; i++) {
            res = res / i;
        }
        return res;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.paintingPlan(2, 4));
    }

}
