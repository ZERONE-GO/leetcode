package p1734;

public class Solution {
    
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        int value = 0;
        for (int encode : encoded) {
            value ^= encode;
        }

        int latest = value;
        for (int encode : encoded) {
            value = encode ^ value;
            latest ^= value;
        }

        for (int i = 1; i <= n; i++) {
            latest ^= i;
        }

        int[] perm = new int[n];
        perm[n - 1] = latest;

        for (int i = n - 2; i >= 0; i--) {
            perm[i] = encoded[i] ^ perm[i + 1];
        }
        return perm;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] encoded = {3,1};
        s.decode(encoded);
    }

}
