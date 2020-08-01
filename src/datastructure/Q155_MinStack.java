package datastructure;

import java.util.Stack;

/**
 * @author zerodsLyn
 * created on 2020/8/1
 */
public class Q155_MinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public Q155_MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int data = dataStack.pop();
        if (!minStack.isEmpty()) {
            int curMin = minStack.peek();
            if (data == curMin) minStack.pop();
        }


    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
