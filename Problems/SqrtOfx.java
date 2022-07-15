/*
69.
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
*/
public class SqrtOfx {
    public static int mySqrt(int x) {
        /* square root of 1 is 1 */
        if (x == 1)
            return 1;
        // range of square root
        int left = 1, right = x / 2;
        // while there are more than one number in range
        while (left <= right) {
            // middle number of range
            int mid = left + (right - left) / 2;
            /* if x divide by mid gives mid, mid is square
             * root
             */
            if (x / mid == mid)
                return mid;
            /* if x divide by mid is more than mid, square 
             * root is bigger number
             */
            if (x / mid > mid)
                left = mid + 1;
            /* if x divide by mid is less than mid, square
             * root is smaller number
             */
            else
                right = mid - 1;
        }
        // remaining one number is square root
        return right;
    }

    public static void main(String[] args) {
        // int x = 4;
        int x = 8;
        // int x = 2147395600;
        System.out.println(mySqrt(x));
    }
}
