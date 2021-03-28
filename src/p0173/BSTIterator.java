package p0173;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    
    private List<TreeNode> iterator;
    private int index;

    public BSTIterator(TreeNode root) {
        iterator = new ArrayList<TreeNode>();
        index = 0;
        iterate(root);
    }
    
    private void iterate(TreeNode node) {
        if(node == null) {
            return;
        }
        
        iterate(node.left);
        iterator.add(node);
        iterate(node.right);
    }

    public int next() {
        int val = iterator.get(index).val;
        index ++;
        return val;
    }

    public boolean hasNext() {
        return index < iterator.size();
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
