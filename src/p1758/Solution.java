package p1758;

public class Solution {
    
    public int minOperations(String s) {
        int start1 =0, start0 =0;
        
        for(int i=0;i < s.length(); i ++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '1') {
                    start0 ++;
                } else {
                    start1 ++;
                }
            } else {
                if(s.charAt(i) == '1') {
                    start1 ++;
                } else {
                    start0 ++;
                }
            }
        }
        
        return start1 < start0 ? start1 : start0;
    }

}
