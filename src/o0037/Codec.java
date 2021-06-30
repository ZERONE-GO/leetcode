package o0037;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<TreeNode> path = new ArrayList<>();
        path.add(root);

        for (int i = 0; i < path.size(); i++) {
            TreeNode node = path.get(i);
            if (node != null) {
                path.add(node.left);
                path.add(node.right);
            }
        }

        int l = path.size() - 1;
        while (path.get(l) == null) {
            l--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= l; i++) {
            TreeNode node = path.get(i);
            if (node != null) {
                sb.append(node.val);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }
        String[] tokens = data.split(",");
        List<TreeNode> path = new ArrayList<TreeNode>();
        int vl = 0;
        TreeNode root = createTreeNode(tokens, vl++);

        if (root != null) {
            path.add(root);

            for (int i = 0; i < path.size(); i++) {
                TreeNode node = path.get(i);
                node.left = createTreeNode(tokens, vl++);
                if (node.left != null) {
                    path.add(node.left);
                }
                node.right = createTreeNode(tokens, vl++);
                if (node.right != null) {
                    path.add(node.right);
                }
            }

        }

        return root;
    }

    private TreeNode createTreeNode(String[] tokens, int vl) {
        if (vl >= tokens.length || tokens[vl].isBlank()) {
            return null;
        }
        return new TreeNode(Integer.valueOf(tokens[vl]));
    }
}
