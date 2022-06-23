/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
*/
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        // stack for operands
        Stack<Integer> stack = new Stack<>();
        // for each item in tokens
        for (int i = 0; i < tokens.length; i++) {
            /* if token is an operand, pop two operands 
            and perform the operation */
            if (tokens[i].equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (tokens[i].equals("-"))
                // first pop will give second operand
                stack.push(- stack.pop() + stack.pop());
            else if (tokens[i].equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (tokens[i].equals("/")) {
                // first pop will give second operand
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            /* if token is an operand, push in stack */
            } else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        // String[] tokens = {"2","1","+","3","*"};
        // String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
