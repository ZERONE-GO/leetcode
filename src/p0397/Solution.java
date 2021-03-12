package p0397;

public class Solution {

    public int integerReplacement(int n) {
        int count = 0;

        while (n != 1) {
            if ((n&1) == 0) {
                n >>>= 1;
            } else {
                if ((n&2) == 0 || n == 3) n -= 1;
                else    n += 1;
            }
            System.out.println(Integer.toBinaryString(n));
            count++;
        }
        return count;
    }
    
    public int integerReplacement2(int n) {
        int step = 0;
        while(n != 1) {
            if((n & 1) == 0) {
                n = n >> 1;
            } else if((n&2) == 0 || n == 3) {
                n = n - 1;
            } else {
                n = n + 1;
            }
            step ++;
            System.out.println(Integer.toBinaryString(n));
            if(n==0) {
                break;
            }
        }
        return step;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.integerReplacement(2147483647));
        System.out.println("\r\n\r\n");
        System.out.println(s.integerReplacement2(2147483647));
    }
}
