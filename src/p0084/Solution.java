package p0084;

public class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int[] minHeights = new int[heights.length];
        
        int res = 0;
        for(int i=0; i < heights.length; i ++) {
            if(heights[i] <= minHeights[i]) {
                continue;
            }
            minHeights[i] = heights[i];
            for(int j=i+1; j < heights.length; j ++) {
//                minHeights[j] = Math.min(a, b);
            }
        }
        
        
        return res;
    }

}
