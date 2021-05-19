package p1738;

import java.util.PriorityQueue;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] xor = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xor[i + 1][j + 1] = xor[i][j + 1] ^ xor[i + 1][j] ^ xor[i][j] ^ matrix[i][j];

                if (queue.size() < k) {
                    queue.add(xor[i + 1][j + 1]);
                } else {
                    if (queue.peek() < xor[i + 1][j + 1]) {
                        queue.poll();
                        queue.add(xor[i + 1][j + 1]);
                    }
                }
            }
        }

        return queue.poll();
    }
}
