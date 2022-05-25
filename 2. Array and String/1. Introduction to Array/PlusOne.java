/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        // array containing incremented digits
        int[] result = new int[digits.length];
        // parity number
        int parity = 1;
        // index from back
        int i = digits.length - 1;
        /* if parity is generated, increment next digit
        and if no parity, stop */
        while (i >= 0) {
            if (digits[i] == 9) {
                parity = 1;
                result[i] = 0;
                i--;
            } else {
                parity = 0;
                result[i] = digits[i] + 1;
                i--;
                break;
            }
        }
        /* if parity exists even after last digit,
        result array will contain one extra digit.
        otherwise copy rest of the digits */
        if (parity == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (i = 1; i < result.length - 1; i++)
                result[i] = 0;
        } else {
            while (i >= 0) {
                result[i] = digits[i];
                i--;
            }
        }
        // return resultant array
        return result;
    }
    public static void main(String[] args) {
        // int[] digits = {1,2,3};
        // int[] digits = {4,3,2,1};
        // int[] digits = {9};
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] result = plusOne(digits);
        for (int item : result)
            System.out.print(item + ",");
        System.out.println();
    }
}
