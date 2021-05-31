package o0404;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getBalancedDepth(root) != -1;
    }

    private int getBalancedDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getBalancedDepth(node.left);
        int right = getBalancedDepth(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (left == right || left == right + 1 || left + 1 == right) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
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
