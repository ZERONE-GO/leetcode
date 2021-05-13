package p1028;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode recoverFromPreorder(String S) {
        List<Integer> nums = new ArrayList<Integer>();
        List<Integer> depth = new ArrayList<Integer>();

        toList(S, nums, depth);

        return constructTreeNode(nums, depth, 0, nums.size(), 0);
    }

    private TreeNode constructTreeNode(List<Integer> nums, List<Integer> depth, int s, int e, int d) {
        if (s >= e) {
            return null;
        }

        if (depth.get(s) == d) {
            TreeNode node = new TreeNode(nums.get(s));

            int left = s + 1, right = left + 1;

            while (right < e) {
                if (depth.get(right) == d + 1) {
                    break;
                }
                right++;
            }
            node.left = constructTreeNode(nums, depth, left, Math.min(right, e), d + 1);
            node.right = constructTreeNode(nums, depth, right, e, d + 1);
            return node;
        } else {
            return null;
        }

    }

    private void toList(String s, List<Integer> nums, List<Integer> depth) {
        int pos = 0;

        while (pos < s.length()) {
            pos = toDepth(s, pos, depth);
            pos = toNum(s, pos, nums);
        }
    }

    private int toNum(String s, int pos, List<Integer> nums) {
        int num = 0;
        while (pos < s.length() && isNum(s.charAt(pos))) {
            num = num * 10 + s.charAt(pos) - '0';
            pos++;
        }
        nums.add(num);
        return pos;
    }

    private int toDepth(String s, int pos, List<Integer> depth) {
        int d = 0;
        while (pos < s.length() && s.charAt(pos) == '-') {
            d++;
            pos++;
        }
        depth.add(d);
        return pos;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        
        s.recoverFromPreorder("1-2--3--4-5--6--7");
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
