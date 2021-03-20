package p0150;

import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            if (isOperation(token)) {
                int result = calc(numbers.pop(), numbers.pop(), token);
                numbers.push(result);
            } else {
                numbers.push(toInt(token));
            }
        }

        return numbers.pop();
    }

    private int calc(int a, int b, String operation) {
        if (operation.equals("+")) {
            return a + b;
        } else if (operation.equals("-")) {
            return b - a;
        } else if (operation.equals("*")) {
            return a * b;
        } else {
            return b / a;
        }
    }

    private boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int toInt(String token) {
        return Integer.valueOf(token);
    }

    public static void main(String args[]) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        Solution s = new Solution();
        s.evalRPN(tokens);
    }
}