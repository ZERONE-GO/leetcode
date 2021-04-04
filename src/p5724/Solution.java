package p5724;

import java.util.Arrays;

public class Solution {
    private static final int MOD = 1000000007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        Integer[] sort = new Integer[nums1.length];
        for(int i=0; i < nums1.length; i ++) {
            sort[i] = i;
        }
        
        Arrays.sort(sort, (a, b)-> {
            return nums1[a] - nums1[b];
        });
        
        int diff = Integer.MIN_VALUE;
        int nv = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i < nums1.length;i ++) {
            int min = minAbs(sort, nums1, nums2, i);
            int v = Math.abs(nums1[i] - nums2[i]);
            if(min < v) {
                if(diff < v -min) {
                    diff = v - min;
                    nv = min;
                    index = i;
                }
            }
        }
        
        int result = index!=-1 ? nv : 0;
        for(int i=0; i < nums1.length; i ++) {
            if(i != index) {
                result = (result + Math.abs(nums1[i] - nums2[i])) % MOD;
            }
        }
        
        return result;
    }
    
    private int minAbs(Integer[] sort, int[] nums1, int[] nums2, int index) {
        int left = -1, right = sort.length-1;
        
        while(left < right) {
            int middle = (left + 1 + right) /2;
            if(nums1[sort[middle]] <= nums2[index]) {
                left = middle;
            } else {
                right = middle-1;
            }
        }
        if(left == -1) {
            return nums1[sort[left+1]] - nums2[index];
        }else if(left == sort.length -1) {
            return nums2[index] - nums1[sort[left]];
        } else {
            return Math.min(nums2[index] - nums1[sort[left]], nums1[sort[left+1]] - nums2[index]);
        }
    }
    
    public static void main(String args[]) {
        int[] nums1 = {1,10,4,4,2,7};
        int[] nums2 = {9,3,5,1,7,4};
        Solution s = new Solution();
        System.out.println(s.minAbsoluteSumDiff(nums1, nums2));
    }
}
