package p0303;

import java.util.Arrays;

class NumArray {

	private int[] sums;

	public NumArray(int[] nums) {
		this.sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return i > 0 ? sums[j] - sums[i - 1] : sums[j];
	}
}
