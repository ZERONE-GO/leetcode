package p0190;

public class Solution {

    public int reverseBits(int n) {
        int result = 0;
        
        for(int i=31; i >=0; i --) {
            result = (result<<1) ^ (n&1);
            n = n >>> 1;
        }
        return result;
    }
}
