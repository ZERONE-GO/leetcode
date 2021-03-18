package p1094;

public class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] path = new int[1001];
        
        for(int[] trip: trips) {
            path[trip[1]] += trip[0];
            path[trip[2]] -= trip[0];
        }
        
        int c = 0;
        for(int p : path) {
            c += p;
            if(c > capacity) {
                return false;
            }
        }
        return true;
    }
}
