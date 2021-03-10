package p0129;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }

    private int sumTree(TreeNode node, int value) {
        if (node == null) {
            return 0;
        }
        value = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            return value;
        }
        int left = sumTree(node.left, value);
        int right = sumTree(node.right, value);
        return left + right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;

            this.right = right;
        }
    }
}
