package p5844;

public class Solution {

    private static final long MOD = 1000000007;

    public int minNonZeroProduct(int p) {
        long res = (1l << p) - 1;
        long n = (1l << (p - 1)) - 1;
        res = (res % MOD) * power((res - 1) % MOD, n);
        return (int) (res % MOD);
    }

    private static long power(long x, long n) {
        long result = 0;
        if (n == 0) {
            result = 1;
        } else {
            result = power(x, n / 2);
            result = (result * result) % MOD;
            if (n % 2 != 0) {
                result = (x * result) % MOD;
            }
        }
        return result % MOD;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.minNonZeroProduct(32));
    }
    
}
