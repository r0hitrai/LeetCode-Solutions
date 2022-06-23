/*
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
*/
public class MyCircularQueue {
    // queue
    private int[] data;
    // point to first item
    private int head;
    // point to last item
    private int tail;
    /* Initializes the object with the size 
    of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        /* point to -1 as queue is empty */
        head = -1;
        tail = -1;
    }
    /* Inserts an element into the circular queue.
    Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        /* when queue is empty 
        set head and tail to 0 index*/
        if (isEmpty()) {
            head++;
            tail++;
            data[tail] = value;
        } else {
            // rotate on queue length
            tail = (tail + 1) % data.length;
            data[tail] = value;
        }
        return true;
    }
    /* Deletes an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        /* when last item deleted,
        move head and tail to -1 */
        if (head == tail) {
            head = -1;
            tail = -1;
        } else
            // rotate on queue length
            head = (head + 1) % data.length;
        return true;
    }
    /* Gets the front item from the queue. If the queue is empty, return -1. */
    public int Front() {
        if (isEmpty())
            return -1;
        return data[head];
    }
    /* Gets the last item from the queue. If the queue is empty, return -1. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return data[tail];
    }
    /* Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        /* empty when head and tail
        point to -1 */
        if (head == -1 && tail == -1)
            return true;
        return false;
    }
    /* Checks whether the circular queue is full or not. */
    public boolean isFull() {
        /* rotate tail on queue length to find
        if next place is head, means queue is full */
        if ((tail + 1) % data.length == head)
            return true;
        return false; 
    }
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

        // MyCircularQueue obj = new MyCircularQueue(2);
        // System.out.println(obj.enQueue(1));
        // System.out.println(obj.enQueue(2));
        // System.out.println(obj.deQueue());
        // System.out.println(obj.enQueue(3));
        // System.out.println(obj.deQueue());
        // System.out.println(obj.enQueue(3));
        // System.out.println(obj.deQueue());
        // System.out.println(obj.enQueue(3));
        // System.out.println(obj.deQueue());
        // System.out.println(obj.Front());
    }
}