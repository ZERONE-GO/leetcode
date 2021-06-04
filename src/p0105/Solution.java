package p0105;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps >= pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);
        int ri = findRoot(inorder, is, ie, preorder[ps]);

        root.left = build(preorder, ps + 1, ps + ri - is + 1, inorder, is, ri);
        root.right = build(preorder, ps + ri - is + 1, pe, inorder, ri + 1, ie);

        return root;
    }

    private int findRoot(int[] inorder, int is, int ie, int root) {
        for (int i = is; i < ie; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
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
