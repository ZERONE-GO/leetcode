package p5693;

public class Solution {

    public int secondHighest(String s) {
        int len = s.length();
        int[] num = {-1, -1};
        
        for(int i=0; i < len; i ++) {
            if(isNum(s.charAt(i))) {
                int n = s.charAt(i) - '0';
                
                if(n > num[0]) {
                    num[1] = num[0];
                    num[0] = n;
                } else if(n == num[0]) {
                    continue;
                } else if(n > num[1]) {
                    num[1] = n;
                }
            }
        }
        return num[1];
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

}
