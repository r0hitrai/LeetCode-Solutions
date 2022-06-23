/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
*/
import java.util.ArrayList;

public class MinStack {
    // stack
    private ArrayList<Integer> data;
    // minimum items
    private ArrayList<Integer> min;
    // top item
    private int top;
    /* initializes the stack object */
    public MinStack() {
        data = new ArrayList<>();
        min = new ArrayList<>();
        top = -1;
    }
    /* pushes the element val onto the stack */
    public void push(int val) {
        data.add(val);
        top++;
        /* first item is always minimum,
        next item is compared with minimum */
        if (top == 0)
            min.add(val);
        else {
            /* store minimum of them in min array */
            if (val < getMin())
                min.add(val);
            else
                min.add(getMin());
        }
    }
    /* removes the element on the top of the stack */
    public void pop() {
        data.remove(top);
        min.remove(min.size() - 1);
        top--;
    }
    /* gets the top element of the stack */
    public int top() {
        return data.get(top);
    }
    /* retrieves the minimum element in the stack */
    public int getMin() {
        return min.get(min.size() - 1);
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}