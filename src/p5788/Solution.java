package p5788;

public class Solution {
    public String largestOddNumber(String num) {
        int len = num.length() - 1;
        while(len >= 0) {
            int  value = num.charAt(len) - '0';
            if((value & 1) == 1) {
                break;
            }
            len --;
        }
        
        return len >= 0 ? num.substring(0, len+1) : "";
    }
}
