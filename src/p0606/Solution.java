package p0606;

public class Solution {

    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        return toStr(t);
    }
    
    private String toStr(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if(t.left != null) {
            sb.append("(").append(toStr(t.left)).append(")");
        } else if(t.right != null){
            sb.append("()");
        }
        if(t.right !=null) {
            sb.append("(").append(toStr(t.right)).append(")");
        }
        return sb.toString();
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
