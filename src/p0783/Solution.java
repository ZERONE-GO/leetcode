package p0783;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root, -1);
        return ans;
    }

    private int dfs(TreeNode node, int prev) {
        if (node == null) {
            return prev;
        }
        int pre = dfs(node.left, prev);
        if (pre != -1) {
            if (ans > node.val - pre) {
                ans = node.val - pre;
            }
        }

        pre = node.val;
        return dfs(node.right, pre);
    }

    public static class TreeNode {
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
