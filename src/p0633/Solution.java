package p0633;

public class Solution {

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i < Math.sqrt(c); i++) {
            int b = c-i*i;
            if (binarySearch(b, i, (long)Math.sqrt(b))) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(long b, long s, long e) {
        while (s <= e) {
            long middle = (s + e) / 2;

            if (middle * middle < b) {
                s = middle + 1;
            } else if (middle * middle > b) {
                e = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.judgeSquareSum(2147483646));
    }
}
