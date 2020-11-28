package p0164;

import java.util.Arrays;

public class Solution {

    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int smallest = nums[0];
        int largest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (smallest > nums[i]) {
                smallest = nums[i];
            }
            if (largest < nums[i]) {
                largest = nums[i];
            }
        }

        int distance = Math.max((largest - smallest) /(nums.length-1), 1);
        int bucketSize = largest/ distance + 1;
        int[][] bucket = new int[bucketSize][2];
        
        for(int i=0; i<bucketSize; i ++) {
            Arrays.fill(bucket[i], -1);
        }

        for (int i = 0; i < nums.length; i++) {
            int bi = (nums[i] - smallest) / distance;

            if (nums[i] < bucket[bi][0] || bucket[bi][0] == -1) {
                bucket[bi][0] = nums[i];
            }
            if (nums[i] > bucket[bi][1] || bucket[bi][1] == -1) {
                bucket[bi][1] = nums[i];
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }

        return ret;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {3,6,9,1,2,3,4};
        System.out.println(s.maximumGap(nums));
    }

}
