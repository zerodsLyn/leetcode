/**
 * @author gengchao05 create on 2019/06/27
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class Q155_MinStack_V2 {
    private ArrayList<Integer> stackData;

    private ArrayList<Integer> minStack;

    /** initialize your data structure here. */
    public Q155_MinStack_V2() {
        stackData = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }

    public void push(int x) {
        stackData.add(x);
        if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x) {
            minStack.add(x);
        }
    }

    public void pop() {
        if (stackData.size() > 0) {
            int top = top();
            int min = getMin();
            stackData.remove(stackData.size() - 1);
            if (top == min) {
                minStack.remove(minStack.size() - 1);
            }
        }
    }

    public int top() {
        if (stackData.size() > 0) {
            return stackData.get(stackData.size() - 1);
        }

        return -1;
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
        Q155_MinStack_V2 minStack = new Q155_MinStack_V2();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
