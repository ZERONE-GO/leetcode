package p5751;

public class Solution {

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, l = Math.min(nums1.length, nums2.length);

        while (i < l && nums1[i] > nums2[0]) {
            i++;
        }
        int res = 0;
        while (i < l) {
            int j = binarySearch(nums2, nums1[i], i);
            if (res < j - i) {
                res = j - i;
            }
            i ++;
        }

        return res;
    }

    private int binarySearch(int[] nums, int v, int left) {
        int right = nums.length-1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < v) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}
