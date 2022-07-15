/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
*/
import java.util.ArrayList;

public class MinStack {
    // stack
    private ArrayList<Node> data;
    // points to top of stack
    int top;
    
    /* Definition of a node */
    class Node {
        // node's value
        int val;
        // minimum value till this node
        int minVal;
        // initialize values
        Node(int _val, int _minVal) {
            val = _val;
            minVal = _minVal;
        }
    }
    /* initializes the stack object */
    public MinStack() {
        data = new ArrayList<>();
        top = -1;
    }
    /* pushes the element val onto the stack */
    public void push(int val) {
        /* first item is always minimum,
        next item is compared with minimum */
        if (top == -1) {
            // increment top pointer
            top++;
            // create new node
            Node node = new Node(val, val);
            // add node in the stack
            data.add(node);
        }
        // if stack is not empty
        else {
            // get minimum between val and last node's minVal
            int min = val < data.get(top).minVal ? val : data.get(top).minVal;
            // increment top
            top++;
            // create new node
            Node node = new Node(val, min);
            // add node in stack
            data.add(node);
        }
    }
    /* removes the element on the top of the stack */
    public void pop() {
        data.remove(top);
        top--;
    }
    /* gets the top element of the stack */
    public int top() {
        return data.get(top).val;
    }
    /* retrieves the minimum element in the stack */
    public int getMin() {
        return data.get(top).minVal;
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // minStack.push(-2);
        // minStack.push(0);
        // minStack.push(-3);
        // System.out.println(minStack.getMin());
        // minStack.pop();
        // System.out.println(minStack.top());
        // System.out.println(minStack.getMin());
        // System.out.println("push -2 :");
        minStack.push(-2);
        // System.out.println(minStack.top());
        // System.out.println("push 0 :");
        minStack.push(0);
        // System.out.println(minStack.top());
        // System.out.println("push -1 :");
        minStack.push(-1);
        // System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}