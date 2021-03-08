package p1775;

public class Solution2 {

    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < len1; i++) {
            sum1 += nums1[i];
        }

        for (int i = 0; i < len2; i++) {
            sum2 += nums2[i];
        }

        if ((len1 > 6 * len2) || (len2 > 6 * len1)) {
            return -1;
        }

        if (sum1 > sum2) {
            return operation(nums1, nums2, sum1 - sum2, 0);
        } else {
            return operation(nums2, nums1, sum2 - sum1, 0);
        }
    }

    private int operation(int[] nums1, int[] nums2, int diff, int count) {
        if (diff == 0) {
            return count;
        }
        int min = 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[min] > nums1[i]) {
                min = i;
            }
        }
        int max = 0;
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[max] < nums2[i]) {
                max = i;
            }
        }

        if (6 - nums1[min] > nums2[max] - 1) {
            if (diff > 6 - nums1[min]) {
                diff = diff - 6 + nums1[min];
                nums1[min] = 6;
            } else {
                diff = 0;
                nums1[min] = diff + nums1[min];
            }
            return operation(nums1, nums2, diff, count + 1);
        } else {
            if (diff > nums2[max] - 1) {
                diff = diff + 1 - nums2[max];
                nums2[max] = 1;
            } else {
                diff = 0;
                nums2[max] = nums2[max] - diff;
            }
            return operation(nums1, nums2, diff, count + 1);
        }
    }

}
