package p0907;

public class Solution2 {
    private static final int MOD = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        for(int i =0; i < arr.length; i ++) {
            int min = arr[i];
            
            for(int j=i; j < arr.length; j ++) {
                if(min > arr[j]) {
                    min = arr[j];
                }
                result = (result + min) % MOD;
            }
        }
        
        return result;
    }
}
