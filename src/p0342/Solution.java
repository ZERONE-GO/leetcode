package p0342;

public class Solution {
    
    public boolean isPowerOfFour(int n) {
        while(n > 1) {
            if((n & 3) == 0) {
                n = n >> 2;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfFour(4));
        System.out.println(s.isPowerOfFour(16));
        System.out.println(s.isPowerOfFour(64));
        System.out.println(s.isPowerOfFour(5));
        System.out.println(s.isPowerOfFour(1));
    }
}
