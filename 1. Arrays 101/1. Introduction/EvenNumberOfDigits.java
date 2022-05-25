/*
Given an array nums of integers, return how many of them contain an even number of digits.
*/

public class EvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        // numbers of even number of digits
        int noEven = 0;
        // for every item in nums
        for (int i = 0; i < nums.length; i++) {
            // item in array, number of digits
            int num = nums[i], digits = 0;
            // for every digit
            while (num > 0) {
                // remove last digit
                num /= 10;
                // increment digits
                digits++;
            }
            // if even number of digits
            if (digits % 2 == 0)
                // increment noEven
                noEven++;
        }
        // return result
        return noEven;
    }
}
