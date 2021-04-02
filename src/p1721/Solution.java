package p1721;

public class Solution {

    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        
        int[] stack1 = new int[height.length];
        int l1 = 0;
        int[] stack2 = new int[height.length];
        int l2 = 0;

        stack1[l1++] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[stack1[l1 - 1]]) {
                stack1[l1++] = i;
            }
        }
        
        int result = 0;
        for (int i = 0; i < l1 - 1; i++) {
            result += height[stack1[i]] * (stack1[i + 1] - stack1[i] - 1);
            for (int j = stack1[i] + 1; j < stack1[i + 1]; j++) {
                result -= height[j];
            }
        }

        stack2[l2++] = height.length - 1;
        for (int i = height.length - 2; i >= stack1[l1-1]; i--) {
            if (height[i] >= height[stack2[l2 - 1]]) {
                stack2[l2++] = i;
            }
        }

        for (int i = 0; i < l2 - 1; i++) {
            result += height[stack2[i]] * (stack2[i] - stack2[i + 1] - 1);
            for (int j = stack2[i] - 1; j > stack2[i + 1]; j--) {
                result -= height[j];
            }
        }

        return result;
    }
    
    public static void main(String args[]) {
        int[] height = {0,1,0,2,1,0,1,3,3,2,1,2,1};
        Solution s = new Solution();
        System.out.println(s.trap(height));
    }

}
