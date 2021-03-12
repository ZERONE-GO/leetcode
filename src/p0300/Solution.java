package p0300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
    int[] lis = new int[nums.length];
    int length = 0;
    
    for(int i=0; i < nums.length; i ++) {
        int pos = Arrays.binarySearch(lis, 0, length, nums[i]);
        if(pos < 0) {
            pos = -pos -1;
            if(pos >= length) {
                lis[pos] = nums[i];
                length ++;
            } else {
                lis[pos] = nums[i];
            }
        }
    }

    return length;
}
}
