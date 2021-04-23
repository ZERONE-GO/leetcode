package p0124;

public class Solution {

    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        
        maxSum = Integer.MIN_VALUE;
        g(root);

        return maxSum;
    }
    
    private int g(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int left = g(node.left);
        int right = g(node.right);
        
        if(maxSum < node.val + left + right) {
            maxSum = node.val + left + right;
        }
        
        int value = node.val + Math.max(left, right);
        return value > 0 ? value : 0;
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
