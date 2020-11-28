package p0493;

public class Solution2 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length);
    }

    public int mergeSort(int[] nums, int start, int end) {
        if (start >= end - 1) {
            return 0;
        }

        int middle = (start + end) / 2;
        int ln = mergeSort(nums, start, middle);
        int rn = mergeSort(nums, middle, end);

        int left = start, right = middle;
        int result = 0;
        while (left < middle) {
            while (right < end && (long)nums[left] > 2 * (long) nums[right]) {
                right++;
            }
            result += right - middle;
            left++;
        }

        left = start;
        right = middle;
        int[] sort = new int[end - start];
        int sl = 0;
        while (left < middle && right < end) {
            if (nums[left] < nums[right]) {
                sort[sl++] = nums[left++];
            } else {
                sort[sl++] = nums[right++];
            }
        }

        while (left < middle) {
            sort[sl++] = nums[left++];
        }

        while (right < end) {
            sort[sl++] = nums[right++];
        }

        for (int i = start; i < end; i++) {
            nums[i] = sort[i - start];
        }
        return result + ln + rn;
    }
    
    public static void main(String args[]) {
        Solution2 s = new Solution2();
        int[] nums = {1,3,2,3,1};
        
        System.out.println(s.reversePairs(nums));
    }

}
