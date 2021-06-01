package o0007;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps >= pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        for (int i = is; i < ie; i++) {
            if (inorder[i] == preorder[ps]) {
                root.left = buildTree(preorder, ps + 1, ps + i - is + 1, inorder, is, i);
                root.right = buildTree(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
                break;
            }
        }

        return root;
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
