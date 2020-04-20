import java.util.Stack;

/**
 * @author zerodsLyn create on 2019/06/27
 * <p>
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element from in front of queue. peek() -- Get the front element. empty() -- Return whether the queue is empty.
 */
public class Q232_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.empty());

    }
}

class MyQueue {
    private Stack<Integer> inStack;

    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.size() + outStack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
