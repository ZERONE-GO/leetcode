package p0099;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void recoverTree(TreeNode root) {
        List<TreeNode> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        recoverTree(root, inOrderList, 0, inOrderList.size());
    }

    private boolean recoverTree(TreeNode root, List<TreeNode> inOrderList, int start, int end) {
        if (root == null) {
            return false;
        }

        int ri = start;
        while (ri < end) {
            if (root == inOrderList.get(ri)) {
                break;
            }
            ri++;
        }

        boolean isLeft = false, isRight = false;
        for (int i = start; i < ri; i++) {
            if (root.val < inOrderList.get(i).val) {
                isLeft = true;
                break;
            }
        }

        for (int i = ri + 1; i < end; i++) {
            if (root.val > inOrderList.get(i).val) {
                isRight = true;
                break;
            }
        }

        if (isLeft && isRight) {
            TreeNode maxNode = findMaxNode(inOrderList, start, ri);
            TreeNode minNode = findMinNode(inOrderList, ri + 1, end);
            swap(maxNode, minNode);
            return true;
        } else if (isLeft) {
            TreeNode maxNode = findMaxNode(inOrderList, start, ri);
            swap(root, maxNode);
            return true;
        } else if (isRight) {
            TreeNode minNode = findMinNode(inOrderList, ri + 1, end);
            swap(root, minNode);
            return true;
        } else {
            return recoverTree(root.left, inOrderList, start, ri) || recoverTree(root.right, inOrderList, ri + 1, end);
        }
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    private TreeNode findMaxNode(List<TreeNode> inOrderList, int start, int end) {
        int maxIndex = start;

        for (int i = start + 1; i < end; i++) {
            if (inOrderList.get(maxIndex).val < inOrderList.get(i).val) {
                maxIndex = i;
            }
        }
        return inOrderList.get(maxIndex);
    }

    private TreeNode findMinNode(List<TreeNode> inOrderList, int start, int end) {
        int minIndex = start;

        for (int i = start + 1; i < end; i++) {
            if (inOrderList.get(minIndex).val > inOrderList.get(i).val) {
                minIndex = i;
            }
        }
        return inOrderList.get(minIndex);
    }

    private void inOrder(TreeNode root, List<TreeNode> inOrderList) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inOrderList);
        inOrderList.add(root);
        inOrder(root.right, inOrderList);
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
