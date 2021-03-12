package p1006;

public class Solution {
    
    public int clumsy(int N) {
        int result = 0;
        boolean flag = true;
        int i=N;
        while(i>=1) {
            int value = 0;
            value = i --;
            if(i >= 1) {
                value = value * i;
                i --;
            } 
            if(i >= 1) {
                value = value/i;
                i --;
            }
            if(flag) {
                result = result + value;
                flag = false;
            } else {
                result = result - value;
            }
            if(i >= 1) {
                result = result + i;
                i --;
            }
        }
        
        
        return result;
    }

}
