package p0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>(m * n);
        
        int left =0, right = n-1, up = 0, down = m-1;
        while(left <=right && up <= down) {
            for(int i=left; i <= right; i ++) {
                result.add(matrix[up][i]);
            }
            
            for(int i=up+1; i <= down; i ++) {
                result.add(matrix[i][right]);
            }
            
            if(left < right && up < down) {
                for(int i=right-1; i >= left; i --) {
                    result.add(matrix[down][i]);
                }
                
                for(int i=down-1; i > up; i --) {
                    result.add(matrix[i][left]);
                }
            }

            left ++;
            right --;
            up ++;
            down --;
        }
        return result;
    }

}
