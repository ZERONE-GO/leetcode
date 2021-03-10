package p0224;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> number = new Stack<Integer>();

        s=s.trim();
        if(s.startsWith("-")) {
            s = 0 + s;
        }
        int l = 0;
        while (l < s.length()) {
            if (isNum(s.charAt(l))) {
                int num = s.charAt(l) - '0';
                l++;
                while (l < s.length() && isNum(s.charAt(l))) {
                    num = num * 10 + s.charAt(l) - '0';
                    l++;
                }
                number.push(num);
            } else if (isOperator(s.charAt(l))) {
                if (!operator.isEmpty()) {
                    char c = operator.peek();
                    if (isOperator(c)) {
                        c = operator.pop();
                        number.push(calc(number, c));
                    }
                }
                operator.push(s.charAt(l));
                l++;
            } else if (s.charAt(l) == '(') {
                operator.push(s.charAt(l));
                l++;
            } else if (s.charAt(l) == ')') {
                char c = operator.pop();
                while (c != '(') {
                    number.push(calc(number, c));
                    c = operator.pop();
                }
                l++;
            } else {
                l++;
            }
        }

        while (!operator.isEmpty()) {
            char c = operator.pop();
            number.push(calc(number, c));
        }

        return number.pop();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    private int calc(Stack<Integer> number, char c) {
        int num1 = number.pop();
        int num2 = number.pop();
        if (c == '+') {
            return num1 + num2;
        } else {
            return num2 - num1;
        }
    }

}
