/**
 * @author zerodsLyn create on 2019/06/27
 */

import java.util.*;

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
    private PriorityQueue<Integer> priorityQueue;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public Q155_MinStack() {
        priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1);
            }
        });
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        priorityQueue.offer(x);
    }

    public void pop() {
        Integer peek = stack.pop();
        priorityQueue.remove(peek);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
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
