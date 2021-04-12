package p0179;

public class Solution {

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (compare(nums[i], nums[j]) < 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private int compare(int a, int b) {
        String ab = "" + a + b;
        String ba = "" + b + a;

        for (int i = 0; i < ab.length(); i++) {
            if (ab.charAt(i) != ba.charAt(i)) {
                return ab.charAt(i) - ba.charAt(i);
            }
        }
        return 0;
    }
}
