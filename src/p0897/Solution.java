package p0897;

public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode vn = new TreeNode();
        middleSearch(root, vn);
        return vn.right;
    }

    private TreeNode middleSearch(TreeNode node, TreeNode prev) {
        if (node == null) {
            return prev;
        }
        prev = middleSearch(node.left, prev);
        node.left = null;
        prev.right = node;
        return middleSearch(node.right, node);
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
