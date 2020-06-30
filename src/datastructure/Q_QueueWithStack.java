package datastructure;

import java.util.Stack;

/**
 * @author zerodsLyn create on 2020/06/30
 */
public class Q_QueueWithStack {
    int size;
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Q_QueueWithStack() {
        size  = 0;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
        size++;
    }

    public int deleteHead() {
        if (size == 0) return -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }

        size--;
        return stack2.pop();
    }
}
