package p0009;

import java.util.Stack;

class CQueue {
    
    private Stack<Integer> headStack;
    private Stack<Integer> tailStack;

    public CQueue() {
        headStack = new Stack<Integer>();
        tailStack = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        tailStack.push(value);
    }
    
    public int deleteHead() {
        if(!headStack.isEmpty()) {
            return headStack.pop();
        } else if(!tailStack.isEmpty()) {
            while(!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
            return headStack.pop();
        } else {
            return -1;
        }
    }
}
