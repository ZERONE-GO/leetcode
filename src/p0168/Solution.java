package p0168;

import java.util.Stack;

public class Solution {

    public String convertToTitle(int columnNumber) {
        Stack<Character> stack = new Stack<>();
        while (columnNumber > 0) {
            int v = (columnNumber-1) % 26;
            columnNumber = (columnNumber-1) / 26;
            stack.push((char)('A' + v));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(576));
//        System.out.println((-5) % 2);
    }
}
