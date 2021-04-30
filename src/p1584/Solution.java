package p1584;

import java.util.PriorityQueue;

public class Solution {

    public int minCostConnectPoints(int[][] points) {
        int[][] map = new int[points.length][points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dis = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                map[i][j] = dis;
                map[j][i] = dis;
            }
        }

        boolean[] color = new boolean[points.length];

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        int[] pair = { 0, 0 };
        queue.add(pair);
        int res = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (!color[p[0]]) {
                color[p[0]] = true;
                res += p[1];

                for (int i = 0; i < points.length; i++) {
                    int[] p2 = new int[2];
                    p2[0] = i;
                    p2[1] = map[p[0]][i];
                    queue.add(p2);
                }
            }
        }

        return res;
    }

}
