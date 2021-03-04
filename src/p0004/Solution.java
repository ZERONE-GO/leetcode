package p0004;

import java.util.Arrays;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int len1 = nums1.length;
	int len2 = nums2.length;

	if (len1 == 0) {
		return medianOfSortedArray(nums2);
	}
	if (len2 == 0) {
		return medianOfSortedArray(nums1);
	}

	int median = (len1 + len2) >> 1;
	int left = 0;
	int right = len1;
	int pivot1 = 0, pivot2 = 0;

	while (left < right) {
		pivot1 = (left + right) >> 1;
		pivot2 = Arrays.binarySearch(nums2, nums1[pivot1]);
		if (pivot2 < 0) {
			pivot2 = -pivot2 - 1;
		} else {
			pivot2 = pivot2 + 1;
		}

		if ((pivot1 + pivot2) == median) {
			break;
		} else if ((pivot1 + pivot2) > median) {
			right = pivot1;
		} else {
			left = pivot1 + 1;
		}
	}

	if ((pivot1 + pivot2) == median) {
		if (((len1 + len2) & 1) == 1) {
			return nums1[pivot1];
		} else {
			if (pivot1 == 0) {
				return (double)(nums1[pivot1] + nums2[pivot2 - 1]) / 2;
			} else if (pivot2 == 0) {
				return (double)(nums1[pivot1] + nums1[pivot1 - 1]) / 2;
			} else {
				int m = Math.max(nums1[pivot1 - 1], nums2[pivot2 - 1]);
				return (double)(nums1[pivot1] + m) / 2;
			}
		}
	}

	left = 0;
	right = len2;

	while (left < right) {
		pivot2 = (left + right) >> 1;
		pivot1 = Arrays.binarySearch(nums1, nums2[pivot2]);
		if (pivot1 < 0) {
			pivot1 = -pivot1 - 1;
		} 

		if ((pivot1 + pivot2) == median) {
			break;
		} else if ((pivot1 + pivot2) > median) {
			right = pivot2;
		} else {
			left = pivot2 + 1;
		}
	}

	if (((len1 + len2) & 1) == 1) {
		return nums2[pivot2];
	} else {
		if (pivot1 == 0) {
			return (double)(nums2[pivot2] + nums2[pivot2 - 1]) / 2;
		} else if (pivot2 == 0) {
			return (double)(nums2[pivot2] + nums1[pivot1 - 1]) / 2;
		} else {
			int m = Math.max(nums1[pivot1 - 1], nums2[pivot2 - 1]);
			return (double)(nums2[pivot2] + m) / 2;
		}
	}
}

private double medianOfSortedArray(int[] nums) {
	int len = nums.length;
	if ((len & 1) == 1) {
		return nums[len >> 1];
	} else {
		return (double)(nums[len >> 1] + nums[(len >> 1) - 1]) / 2;
	}
}
}