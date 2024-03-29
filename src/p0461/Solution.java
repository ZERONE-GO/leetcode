package p0461;

public class Solution {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >>> 1;
        }

        return count;
    }

}
