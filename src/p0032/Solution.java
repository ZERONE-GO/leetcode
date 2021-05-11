package p0032;

import java.util.Stack;

public class Solution {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int left = findLeftParenthese(s, i, stack);
                if (left >= 0) {
                    left = appendPrefix(s, left, stack);
                    value = Math.max(value, i - left + 1);
                    stack.push(i - left + 1);
                } else {
                    stack.push(-1);
                }
            }
        }
        return value;
    }

    public int appendPrefix(String s, int left, Stack<Integer> stack) {
        int tmp = left;

        while (tmp - 1 >= 0 && s.charAt(tmp - 1) == ')') {
            if (stack.peek() != -1) {
                tmp = tmp - stack.pop();
            } else {
                break;
            }
        }

        return tmp;
    }

    private int findLeftParenthese(String s, int i, Stack<Integer> stack) {
        int left = i - 1;

        while (left >= 0 && s.charAt(left) != '(') {
            int len = stack.pop();

            if (len > 0) {
                left = left - len;
            } else {
                return -1;
            }
        }

        return left;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        
        System.out.println(s.longestValidParentheses(")()())"));
    }

}
