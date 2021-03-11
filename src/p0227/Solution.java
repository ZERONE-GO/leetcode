package p0227;

import java.util.Stack;

public class Solution {
    
    public int calculate(String s) {
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> numbers = new Stack<Integer>();
        
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(isOperator(c)) {
                if(c == '*' || c == '/') {
                    if(!operators.isEmpty())  {
                        char previous = operators.peek();
                        if(previous == '*' || previous =='/')  {
                            previous = operators.pop();
                            numbers.push(calc(previous, numbers));
                        }
                    }
                    operators.push(c);
                } else {
                    while(!operators.isEmpty()) {
                        char op = operators.pop();
                        numbers.push(calc(op, numbers));
                    }
                    operators.push(c);
                }
                index ++;
            } else if(isNum(c)) {
                int num = 0;
                while(index < s.length() && isNum(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index ++;
                }
                numbers.push(num);
            } else {
                index ++;
            }
        }
        
        while(!operators.isEmpty()) {
            char op = operators.pop();
            numbers.push(calc(op, numbers));
        }
        return numbers.pop();
    }
    
    private int calc(char c, Stack<Integer> numbers) {
        int num1 = numbers.pop();
        int num2 = numbers.pop();
        if(c == '+') {
            return num1 + num2;
        } else if(c == '-') {
            return num2 - num1;
        } else if(c == '*') {
            return num1 * num2;
        } else {
            return num2/num1;
        }
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private boolean isNum(char c) {
        return c >='0' &&c <='9';
    }
    
    public static void main(String args[]) {
        Solution s =new Solution();
        System.out.println(s.calculate("3+2*2"));
    }

}
