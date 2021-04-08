package p0153;

public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[left]) {
                left = middle;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                break;
            }
        }

        return nums[right];
    }

}
