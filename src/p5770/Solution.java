package p5770;

import java.util.Stack;

public class Solution {
    public int minOperationsToFlip(String expression) {
        int left =0, right = expression.length()-1; 
        return minOperation(expression, left, right);
    }
    
    private int minOperation(String e, int left, int right) {        
        Stack<Integer> numberStack = new Stack<>();
        Stack<Integer> operaterStack = new Stack<>();
        int ccount = 0;
        
        for(int i=left; i <= right; i ++) {
            if(isNum(e.charAt(i))) {
                numberStack.push(e.charAt(i) - '0');
            } else if(e.charAt(i) == '(') {
                ccount ++;
                operaterStack.push(i);
            } else if(e.charAt(i) == '&' || e.charAt(i) == '|') {
                if(!operaterStack.isEmpty()) {
                    if(e.charAt(operaterStack.peek()) == '&' || e.charAt(operaterStack.peek()) == '|') {
                        numberStack.push(calc(numberStack.pop(), numberStack.pop(), e.charAt(operaterStack.pop())));
                    }
                }
                operaterStack.push(i);
            } else {
                while(ccount >0 && e.charAt(operaterStack.peek()) != '(') {
                    numberStack.push(calc(numberStack.pop(), numberStack.pop(), e.charAt(operaterStack.pop())));
                }
                operaterStack.pop();
            }
        }
        
        if(operaterStack.isEmpty() && (e.charAt(operaterStack.peek()) != '|' && e.charAt(operaterStack.peek()) != '&')) {
            return 1;
        } else {
            int a = numberStack.pop(), b = numberStack.pop();
            int op = operaterStack.peek();
            if(e.charAt(op) == '&') {
                if(a == 1 && b == 1) {
                    return Math.min(minOperation(e, left, op -1 ),  minOperation(e, op + 1, right));
                } else if(a == 1 || b == 1) {
                    return 1;
                } else {
                    return Math.min(minOperation(e, left, op -1 ),  minOperation(e, op + 1, right)) + 1;
                }
            } else {
                if(a == 0 && b == 0) {
                    return Math.min(minOperation(e, left, op -1 ),  minOperation(e, op + 1, right));
                } else if(a == 0 || b == 0) {
                    return 1;
                } else {
                    return Math.min(minOperation(e, left, op -1 ),  minOperation(e, op + 1, right)) + 1;
                }
            }
        }
    }
    
    private int calc(int a, int b, char c) {
        if(c == '&') {
            return a & b;
        } else {
            return a | b;
        }
    }
    
    private boolean isNum(char c) {
        return c == '1' || c == '0';
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
//        System.out.println(s.minOperationsToFlip("1&(0|1)"));
        System.out.println(s.minOperationsToFlip("(0&0)&(0&0&0)"));
        System.out.println(s.minOperationsToFlip("(0|(1|0&1))"));
        System.out.println(s.minOperationsToFlip("((1))"));
    }
}
