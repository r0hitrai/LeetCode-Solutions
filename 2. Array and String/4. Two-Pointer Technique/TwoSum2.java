/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
*/
public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        // index of two numbers
        int[] result = new int[2];
        /* index from front and back */
        int i = 0;
        int j = numbers.length - 1;
        /* sum each element from front and back */
        while (i < j) {
            /* if sum is more than target, next item from back */
            if (numbers[i] + numbers[j] > target)
                j--;
            /* if sum is less than target, next item from front */
            else if (numbers[i] + numbers[j] < target)
                i++;
            /* if sum is equal to target, save and stop */
            else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        // int[] numbers = {2,3,4};
        // int target = 6;
        // int[] numbers = {-1,0};
        // int target = -1;
        int[] result = twoSum(numbers, target);
        for (int item : result)
            System.out.println(item);
    }
}
