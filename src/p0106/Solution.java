package p0106;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) {
            return null;
        }

        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if(is > ie) {
            return null;
        }
        TreeNode tree = new TreeNode(postorder[pe]);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                tree.left = build(inorder, is, i - 1, postorder, ps, ps + i - is - 1);
                tree.right = build(inorder, i + 1, ie, postorder, ps + i - is, pe - 1);
                break;
            }
        }
        return tree;
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
