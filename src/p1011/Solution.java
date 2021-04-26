package p1011;

public class Solution {
    
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for(int i=0; i < weights.length; i ++) {
            left = left < weights[i] ? weights[i] : left;
            right += weights[i];
        }
        while(left <= right) {
            int ship = left + (right - left) / 2;
            if(count(weights, ship) > D) {
                left = ship + 1;
            } else {
                right = ship - 1;
            }
        }
        return left;
    }
    
    private int count(int[] weights, int ship) {
        int count = 0;
        int sum = 0;
        for(int i=0; i < weights.length; i ++) {
            if(sum + weights[i] > ship) {
                count ++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        if(sum > 0) {
            count ++;
        }
        return count;
    }
    
    public static void main(String args[]) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        Solution s = new Solution();
        s.shipWithinDays(weights, 5);
    }
}
