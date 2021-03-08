package p1779;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = dis(x, y, points[i][0], points[i][1]);

                if (min > dis) {
                    min = dis;
                    result = i;
                }
            }
        }
        return result;
    }

    private int dis(int x, int y, int a1, int b1) {
        return Math.abs(x - a1) + Math.abs(y - b1);
    }
}
