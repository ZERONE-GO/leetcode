package p0055;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        return depth(root) >=0;
    }
    
    private int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if(left < 0 || right < 0 || left > right + 1 || left < right - 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
