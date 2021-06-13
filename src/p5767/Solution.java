package p5767;

import java.util.Arrays;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
       Arrays.sort(ranges, (a, b) -> {
           if(a[0] == b[0]) {
               return a[1] - b[1];
           }
           return a[0] - b[0];
       });
       
       for(int i=0; i < ranges.length; i ++) {
           if(ranges[i][0] > left) {
               return false;
           } else if(ranges[i][1] < left) {
               continue;
           } else if(ranges[i][1] >= right) {
               return true;
           } else {
               left = Math.max(left, ranges[i][1] + 1);
           } 
       }
       return left > right;
   }
}
