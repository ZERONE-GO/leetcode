package p0232;

import java.util.Stack;

class MyQueue {
    
    private Stack<Integer> enterStack;
    private Stack<Integer> outerStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        enterStack = new Stack<Integer>();
        outerStack = new Stack<Integer>();

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enterStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        moveStack();
        return outerStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        moveStack();
        return outerStack.peek();
    }
    
    private void moveStack() {
        if(outerStack.empty()) {
            while(!enterStack.empty()) {
                outerStack.push(enterStack.pop());
            }
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return enterStack.empty() && outerStack.empty();
    }
}