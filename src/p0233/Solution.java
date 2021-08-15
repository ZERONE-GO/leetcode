package p0233;

public class Solution {

    public int countDigitOne(int n) {
        int ans = 0;

        int k = 1;
        while (n >= k) {
            int tmp = k * 10;
            ans += (n / tmp) * k + calcSubfix(n, tmp, k);
            k = tmp;
        }

        return ans;
    }

    private int calcSubfix(int n, int tmp, int k) {
        int res = n % tmp - k + 1;

        if (res >= k) {
            return k;
        } else if (res <= 0) {
            return 0;
        } else {
            return res;
        }
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        s.countDigitOne(13);
    }

}
