package p0103;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> treeList = new ArrayList<>();
        treeList.add(root);
        int zl = 0, ze = 1;
        while (zl < ze) {
            List<Integer> zigList = new ArrayList<>();
            for (int i = zl; i < ze; i++) {
                TreeNode node = treeList.get(i);
                zigList.add(node.val);
            }
            result.add(zigList);

            for (int i = ze - 1; i >= zl; i--) {
                TreeNode node = treeList.get(i);
                if (node.right != null) {
                    treeList.add(node.right);
                }
                if (node.left != null) {
                    treeList.add(node.left);
                }
            }

            zl = ze;
            ze = treeList.size();
            List<Integer> zagList = new ArrayList<>();
            for (int i = zl; i < ze; i++) {
                TreeNode node = treeList.get(i);
                zagList.add(node.val);
            }
            if(!zagList.isEmpty()) {
                result.add(zagList);
            }

            for (int i = ze - 1; i >= zl; i--) {
                TreeNode node = treeList.get(i);
                if (node.left != null) {
                    treeList.add(node.left);
                }
                if (node.right != null) {
                    treeList.add(node.right);
                }
            }
            zl = ze;
            ze = treeList.size();
        }

        return result;
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
