/*
9.
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.

URL : https://leetcode.com/problems/palindrome-number/
*/

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        /* negative numbers are not palidrome */
        if (x < 0)
            return false;
        // convert integer into string
        String num = Integer.toString(x);
        // index from front and back of string
        int front = 0, back = num.length() - 1;
        /* compare front and back digits while they come to
         * same index
         */
        while (front < back) {
            /* if front and back digit is not same, not a 
             * palindrome
             */
            if (num.charAt(front) != num.charAt(back))
                return false;
            // next index from front
            front++;
            // next index from back
            back--;
        }
        // if all digits from front and back is same, it is a
        // palindrome
        return true;
    }
    public static void main(String[] args) {
        // int x = 121;
        // int x = 123;
        // int x = -121;
        // int x = 10;
        int x = 0;
        System.out.println(isPalindrome(x));
    }
}
