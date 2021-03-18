package p1792;

import java.util.PriorityQueue;

public class Solution {
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a,b)->{
            double x = (a[0] + 1)/(a[1] + 1) - (a[0]/a[1]);
            double y = (b[0] + 1)/(b[1] + 1) - (b[0]/b[1]);
            if(x > y) {
                return -1;
            } else {
                return 1;
            }
        });
        
        for(int[] claz : classes) {
            queue.offer(new double[] {claz[0], claz[1]});
        }
        
        while(extraStudents > 0) {
            double[] top = queue.poll();
            top[0] += 1;
            top[1] += 1;
            queue.offer(top);
            extraStudents --;
        }
        
        double result = 0.0;
        
        while(!queue.isEmpty()) {
            double[] top = queue.poll();
            result += top[0]/top[1];
        }
        
        return result/classes.length;
    }
    

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] classes = {{1,2},{3,5}, {2,2}};
        s.maxAverageRatio(classes, 2);
    }
    
}
