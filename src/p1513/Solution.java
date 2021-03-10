package p1513;

public class Solution {
    private static int MOD = 1000000007;

    public int numSub(String s) {
        long result = 0;
        long n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                n++;
            } else {
                result += calc(n);
                result = result % MOD;
                n = 0;
            }
        }
        result += calc(n);
        result = result % MOD;
        return (int) result;
    }

    private long calc(long n) {
        long result;
        if ((n & 1) == 1) {
            result = ((n + 1) >> 1) * n;
        } else {
            result = (n >> 1) * (n + 1);
        }
        return result % MOD;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.numSub("0110111");
    }

}
