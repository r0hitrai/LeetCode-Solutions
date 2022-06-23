/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
*/
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        /* for every open parenthesis, push it in stack,
        for every closing parenthesis, pop only for latest
        parenthesis */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (stack.empty())
                return false;
            else if (c == ')') {
                if (stack.peek().equals('('))
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (stack.peek().equals('{'))
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (stack.peek().equals('['))
                    stack.pop();
                else
                    return false;
            }
        }
        /* if stack empty, valid
        else invalid */
        if (stack.empty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        // String s = "()";
        // String s = "()[]{}";
        // String s = "(]";
        // String s = "]";
        String s = "(])";
        System.out.println(isValid(s));
    }
}
