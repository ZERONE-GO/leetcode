package p1094;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];
        
        for(int i=0; i<trips.length; i ++) {
            for(int j=trips[i][1]; j < trips[i][2]; j ++) {
                road[j] += trips[i][0];
            }
        }

        for(int i=0; i < road.length; i ++ ) {
            if(road[i] > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
