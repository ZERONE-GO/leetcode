package p1759;

public class Solution {
    
    private static final int MOD= 1000000007;

    public int countHomogenous(String s) {
        long result =0;
        
        int len = 1;
        int index = 1;
        while(index < s.length()) {
            if(s.charAt(index) != s.charAt(index-1)) {
                result = (result + count(len)) % MOD;
                len = 1;
            } else {
                len ++;
            }
            index ++;
        }
        result = (result + count(len)) % MOD;
        return (int)result;
    }
    
    private long count(long len) {
        if((len&1) == 1) {
            return ((len+1)/2 * len) % MOD;
        } else {
            return (len /2 * (len+1)) % MOD;
        }
    }

}
