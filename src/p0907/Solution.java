package p0907;

public class Solution {
    private static final int MOD = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        for(int i =0; i < arr.length; i ++) {
            int left = i-1, right = i+1;
            while(left >= 0 && arr[left] > arr[i]) {
                left --;
            }
            while(right < arr.length && arr[right] >= arr[i]) {
                right ++;
            }
            result = (result + (long)(i-left) * (long)(right - i) * (long)arr[i] % MOD) % MOD;
        }
        
        return (int)result;
    }
    
    public static void main(String args[]) {
        int[] arr = {71,55,82,55};
        
        Solution s = new Solution();
        System.out.println(s.sumSubarrayMins(arr));
        
    }
}
