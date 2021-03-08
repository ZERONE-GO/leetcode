package p1775;

public class Solution {

    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int sum1 = 0, sum2 = 0;
        int[] bucket1 = new int[7];
        int[] bucket2 = new int[7];

        for (int i = 0; i < len1; i++) {
            sum1 += nums1[i];
            bucket1[nums1[i]]++;
        }

        for (int i = 0; i < len2; i++) {
            sum2 += nums2[i];
            bucket2[nums2[i]]++;
        }

        if ((len1 > 6 * len2) || (len2 > 6 * len1)) {
            return -1;
        }

        if (sum1 > sum2) {
            return operation(bucket2, bucket1, sum1 - sum2, 0);
        } else {
            return operation(bucket1, bucket2, sum2 - sum1, 0);
        }
    }

    private int operation(int[] bucket1, int[] bucket2, int diff, int count) {
        if (diff == 0) {
            return count;
        }

        int min = 1;
        while (bucket1[min] == 0) {
            min++;
        }
        int max = 6;
        while (bucket2[max] == 0) {
            max--;
        }

        if (6 - min > max - 1) {
            if (diff < 6 - min) {
                diff = 0;
                bucket1[min]--;
                bucket1[diff + min]++;
                count++;
            } else {
                while (diff > 6 - min) {
                    diff = diff - 6 + min;
                    bucket1[min]--;
                    bucket1[6]++;
                    count++;
                }
            }
            return operation(bucket1, bucket2, diff, count);
        } else {
            if (diff < max - 1) {
                diff = 0;
                bucket2[max]--;
                bucket2[max - diff]++;
                count++;
            } else {
                while (diff > max - 1) {
                    diff = diff + 1 - max;
                    bucket2[max]--;
                    bucket2[1]++;
                    count++;
                }
            }

            return operation(bucket1, bucket2, diff, count + 1);
        }
    }

}
