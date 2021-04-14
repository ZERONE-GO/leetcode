package p1824;

public class Solution {
    
    public int minSideJumps(int[] obstacles) {
        int[] prev = new int[3];
        int[] cur = new int[3];
        
        int n = obstacles.length;
        for(int i = n-2; i >=0; i --) {
            if(obstacles[i] == 1) {
                cur[0] = n;
                cur[1] = Math.min(prev[1], prev[2] + 1);
                cur[2] = Math.min(prev[2], prev[1] + 1);
            } else if(obstacles[i] == 2) {
                cur[1] = n;
                cur[0] = Math.min(prev[0], prev[2] + 1);
                cur[2] = Math.min(prev[2], prev[0] + 1);
            }  else if(obstacles[i] == 3) {
                cur[2] = n;
                cur[0] = Math.min(prev[0], prev[1] + 1);
                cur[1] = Math.min(prev[1], prev[0] + 1);
            } else {
                cur[0] = Math.min(prev[0], Math.min(prev[1] + 1, prev[2] + 1));
                cur[1] = Math.min(prev[1], Math.min(prev[0] + 1, prev[2] + 1));
                cur[2] = Math.min(prev[2], Math.min(prev[0] + 1, prev[1] + 1));
            }
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }
        return prev[1];
    }
}

