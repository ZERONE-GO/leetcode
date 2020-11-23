package p0452;

import java.util.Arrays;

public class Solution {
    
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        int shots = 0;
        int index = 0;
        while (index < points.length) {
            int[] conver = { points[index][0], points[index][1] };
            
            index ++;
            while ( index < points.length) {
                if ((conver[0] <= points[index][0] && conver[1] >= points[index][0])
                        || (conver[0] <= points[index][0] && conver[1] >= points[index][1])) {
                    conver[0] = Math.max(conver[0], points[index][0]);
                    conver[1] = Math.min(conver[1], points[index][1]);
                    index ++;
                } else {
                    break;
                }
            }
            shots++;
        }

        return shots;
    }

}
