package o0043;

public class Solution {

    public int countDigitOne(int n) {
        int count = 0;
        long ln = n;
        long size = 10;
        while (ln >= size) {
            count += (ln / size) * (size / 10);
            size = size * 10;
        }

        while (size >= 10) {
            long tmp = ln % size;
            if (tmp >= 2 * size / 10 - 1) {
                count += size / 10;
            } else if (tmp < size / 10) {
                count += 0;
            } else {
                count += tmp - size / 10 + 1;
            }
            size = size / 10;
        }

        return count;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.countDigitOne(112);
    }

}
