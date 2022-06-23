/*
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
import java.util.Stack;

public class ImplementQueueUsingStacks {
    // stack for push operation
    private Stack<Integer> enqueue;
    // stack for pop operation
    private Stack<Integer> dequeue;
    /* initialize stacks */
    public ImplementQueueUsingStacks() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }
    /* Pushes element x to the back of the queue. */
    public void push(int x) {
        /* if items in dequeue, push it in enqueue */
        while (!dequeue.isEmpty())
            enqueue.push(dequeue.pop());
        // push new item in enqueue
        enqueue.push(x);
    }
    /* Removes the element from the front of the queue and returns it. */
    public int pop() {
        /* if items in enqueue, push it in dequeue */
        while (!enqueue.isEmpty())
            dequeue.push(enqueue.pop());
        // pop top of dequeue and return it
        return dequeue.pop();
    }
    /* Returns the element at the front of the queue. */
    public int peek() {
        /* if items in enqueue, push it in dequeue */
        while (!enqueue.isEmpty())
            dequeue.push(enqueue.pop());
        // return top of dequeue
        return dequeue.peek();
    }
    /* Returns true if the queue is empty, false otherwise. */
    public boolean empty() {
        // if both stacks are empty, then queue is empty
        return (enqueue.isEmpty() && dequeue.isEmpty()) ? true : false;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}