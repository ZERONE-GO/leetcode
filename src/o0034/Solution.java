package o0034;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        fs(paths, root, 0, target, path);
        
        return paths;
    }

    private void fs(List<List<Integer>> paths, TreeNode node, int sum, int target, List<Integer> path) {
        if(node == null) {
            return;
        }
        sum = sum + node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                List<Integer> np = new ArrayList<Integer>(path);
                paths.add(np);
            }
            path.remove(path.size() - 1);
            return;
        }
        
        if(node.left != null) {
            fs(paths, node.left, sum, target, path);
        }
        if(node.right != null) {
            fs(paths, node.right, sum, target, path);
        }
        path.remove(path.size() - 1);
    }


}
