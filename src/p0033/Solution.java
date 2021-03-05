package p0033;

public class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] >= nums[left]) {
                if (nums[middle] < target) {
                    left = middle + 1;
                } else if (nums[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] > target) {
                    right = middle - 1;
                } else if (nums[right] >= target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            middle = (left + right) / 2;
        }

        return -1;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {3,1};
        System.out.println(s.search(nums, 1));
        
    }

}
