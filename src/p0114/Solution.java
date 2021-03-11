package p0114;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        ds(root);
    }

    public TreeNode ds(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left == null && right == null) {
            return node;
        }
        if(left != null) {
            node.right = node.left;
            node.left = null;
            left = ds(left);
            if(right != null) {
                left.right = right;
                return ds(right);
            }
            return left;
        } else {
            return ds(right);
        }
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
