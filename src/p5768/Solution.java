package p5768;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0; 
        for(int i=0; i < chalk.length; i ++) {
            sum += chalk[i];
        }
        
        long remain = k % sum; 
        
        for(int i=0; i < chalk.length; i ++) {
            if(remain < chalk[i]) {
                return i;
            }
            remain -= chalk[i];
        }
        
        return 0;
    }
}
