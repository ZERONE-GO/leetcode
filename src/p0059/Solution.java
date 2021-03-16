package p0059;

public class Solution {
    
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int left = 0, right = n-1, top = 0, down = n -1;
        int v = 1;
        while(left <= right && top <= down) {
            // left
            for(int i=left; i <= right; i ++) {
                result[top][i] = v;
                v ++;
            }
            //down 
            for(int i= top+1; i <= down; i ++) {
                result[i][right] = v;
                v ++;
            }
            if(left < right && top < down) {
                //right
                for(int i=right-1; i >= left; i --) {
                    result[down][i] = v;
                    v ++;
                }
                //up
                for(int i=down-1; i > top; i --) {
                    result[i][left] = v;
                    v ++;
                }
            }
            top ++; down --;
            left++; right --;
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.generateMatrix(3));
    }

}
