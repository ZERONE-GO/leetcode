package p1802;

public class Solution2 {

    public int maxValue(int n, int index, int maxSum) {
        int left = maxSum/n, right = maxSum;
        int middle = 0;
        while(left <= right) {
            middle = (left + right) / 2;
            
            long sum = sum(middle, index + 1) + sum(middle-1, n - index - 1); 
            if(sum > maxSum) {
                right = middle - 1;
            } else if(sum < maxSum) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        long sum = sum(middle, index + 1) + sum(middle-1, n - index - 1); 
        return sum < maxSum ? middle : middle - 1;
    }
    
    private long sum(long num, long k) {
        if(num >= k) {
            if((k&1) == 1) {
                return num * k - (k-1)/2 * k;
            } else {
                return num * k - k/2 * (k-1);
            }
        } else {
            if((num&1) == 1) {
                return ((num+1) /2 * num) + k-num;
            } else {
                return (num / 2 * (num+1)) + k-num;
            }
        }
    }
    
    public static void main(String args[]) {
        Solution2 s = new Solution2();
        System.out.println(s.maxValue(6, 2, 931384943));
    }
}
