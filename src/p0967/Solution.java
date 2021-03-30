package p0967;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public int[] numsSameConsecDiff(int n, int k) {
        int[] num = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        
        for(int i = 1; i <=9; i ++) {
            num[0] = i;
            generateNumber(num, k, 1, n, nums);
        }
        
        int[] result = new int[nums.size()];
        
        for(int i=0; i < nums.size(); i ++) {
            result[i] = nums.get(i);
        }
        
        return result;
    }
    
    private void generateNumber(int[] num, int k, int i, int n, List<Integer> nums) {
        if(i == n) {
            nums.add(toNum(num));
            return;
        }
        
        if(k == 0) {
            num[i] = num[i-1];
            generateNumber(num, k, i + 1, n, nums);
            return;
        }
        
        if(num[i-1] - k >=0) {
            num[i] = num[i-1] - k;
            generateNumber(num, k, i + 1, n, nums);
        }
        if(num[i-1] + k <= 9) {
            num[i] = num[i-1] + k;
            generateNumber(num, k, i + 1, n, nums);
        }
    }
    
    private int toNum(int[] num) {
        int value = 0;
        for(int i=0; i < num.length; i ++) {
            value = value * 10 + num[i];
        }
        return value;
    }

}
