package p0030;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        numStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        numStack.push(x);
        if(!minStack.isEmpty()) {
            if(minStack.peek() < x) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }
    
    public void pop() {
            numStack.pop();
            minStack.pop();
    }
    
    public int top() {
            return numStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
