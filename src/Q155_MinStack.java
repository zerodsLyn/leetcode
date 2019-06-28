/**
 * @author gengchao05
 * create on 2019/06/27
 */

import java.util.ArrayList;
import java.util.LinkedList;
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
public class Q155_MinStack {
    private int size;
    private ArrayList<Integer> stackData;
    private PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public Q155_MinStack() {
        stackData = new ArrayList<Integer>(10);
        pq = new PriorityQueue<Integer>();
        size = 0;
    }

    public void push(int x) {
        stackData.add(x);
        pq.add(x);
        size++;
    }

    public void pop() {
        if (size > 0) {
            int top = top();
            stackData.remove(--size);
            pq.remove(top);
        }
    }

    public int top() {
        if (size > 0) {
            return stackData.get(size - 1);
        }

        return -1;
    }

    public int getMin() {
        return pq.peek();
    }

    public static void main(String[] args) {
        Q155_MinStack minStack = new Q155_MinStack();
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
