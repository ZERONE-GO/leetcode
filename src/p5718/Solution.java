package p5718;

public class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {

                int dis = (queries[i][0] - points[j][0]) * (queries[i][0] - points[j][0])
                        + (queries[i][1] - points[j][1]) * (queries[i][1] - points[j][1]);
                if (dis <= queries[i][2] * queries[i][2]) {
                    count[i]++;
                }
            }
        }
        return count;
    }

}
