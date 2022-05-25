/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
*/

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        // index whose all left and right items sum
        // is same
        int pivot = 0;
        /* sum of all items in nums array */
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++)
            totalSum += nums[i];
        /* find sum of left and right side of 
        current index while they becomes same or
        last index is traversed */
        int leftSum = 0;
        int rightSum = totalSum - nums[pivot];
        while (leftSum != rightSum && pivot < nums.length - 1) {
            pivot++;
            // left sum will be adding left item
            leftSum += nums[pivot - 1];
            // right sum will be subtracting right item
            rightSum -= nums[pivot];
        }
        /* if leftSum equals righSum, then return pivot
        otherwise, return -1 */
        if (leftSum == rightSum)
            return pivot;
        else
            return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        // int[] nums = {1,2,3};
        // int[] nums = {2,1,-1};
        // int[] nums = {-1,-1,-1,1,1,1};
        int pivot = pivotIndex(nums);
        System.out.println(pivot);
    }
}