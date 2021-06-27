package p5782;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd = nums[0], even = 0;

        for (int i = 1; i < nums.length; i++) {
            long no = even + nums[i];
            long ne = odd - nums[i];
            if (odd < no) {
                odd = no;
            }
            if (even < ne) {
               even = ne;
            }
        }

        return odd > even ? odd : even;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {4 ,2, 5, 3};
        s.maxAlternatingSum(nums);
    }
}
