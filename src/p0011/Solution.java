package p0011;

class Solution {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;

		int area = 0;

		while (left < right) {
			int h = Math.min(height[left], height[right]);

			int tmp = h * (right - left);

			if (tmp > area) {
				area = tmp;
			}

			if (height[left] <= h) {
				left++;
			} else {
				right--;
			}
		}

		return area;
	}
}