/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
*/
import java.util.Queue;
import java.util.LinkedList;

public class ImplementStackUsingQueues {
    /* queues */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /* intialize queues */
    public ImplementStackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /* Pushes element x to the top of the stack. */
    public void push(int x) {
        /* if queue1 is empty, enqueue in queue2 */
        if (queue1.isEmpty())
            queue2.offer(x);
        /* else, vice versa */
        else
            queue1.offer(x);
    }
    /* Removes the element on the top of the stack and returns it. */
    public int pop() {
        // poped item
        int item = 0;
        /* if queue1 is empty, pop from queue2 */
        if (queue1.isEmpty()) {
            // System.out.println("before queue1 : " + queue1);
            // System.out.println("before queue2 : " + queue2);
            /* copy items from queue2 to queue1 except last item */
            while (queue2.size() > 1)
                queue1.offer(queue2.poll());
            // pop last item
            item = queue2.poll();
            // System.out.println("after queue1 : " + queue1);
            // System.out.println("after queue2 : " + queue2);
        /* else, vice versa */
        } else {
            // System.out.println("before queue1 : " + queue1);
            // System.out.println("before queue2 : " + queue2);
            while (queue1.size() > 1)
                queue2.offer(queue1.poll());
            item = queue1.poll();
            // System.out.println("after queue1 : " + queue1);
            // System.out.println("after queue2 : " + queue2);
        }
        return item;
    }
    /* Returns the element on the top of the stack. */
    public int top() {
        /* top item */
        int item = 0;
        /* if queue1 is empty, take item from queue2 */
        if (queue1.isEmpty()) {
            /* copy queue2 items in queue1 */
            while (!queue2.isEmpty()) {
                item = queue2.poll();
                queue1.offer(item);
            }
        /* else, vice versa */
        } else {
            while (!queue1.isEmpty()) {
                item = queue1.poll();
                queue2.offer(item);
            }
        }
        return item;
    }
    /* Returns true if the stack is empty, false otherwise. */
    public boolean empty() {
        // if both queues are empty, return true
        return (queue1.isEmpty() && queue2.isEmpty()) ? true : false;
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();
        
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        
        // myStack.push(1);
        // myStack.push(2);
        // myStack.push(3);
        // System.out.println(myStack.pop());
        // System.out.println(myStack.pop());
        // System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
