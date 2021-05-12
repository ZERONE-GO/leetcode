package p1310;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        int[] res = new int[queries.length];

        for (int i = 0; i < arr.length; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][1] + 1] ^ xor[queries[i][0]];
        }

        return res;
    }
}
