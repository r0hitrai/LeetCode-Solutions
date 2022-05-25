/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
*/

public class LargestNumberAtLeastTwiceOfOthers {
    public static int dominantIndex(int[] nums) {
        // index of the max number
        int index = 0;
        /* put max number to last by camparing adjacent
        number. store max number to right and double the
        left number. */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i] * 2;
                nums[i] = temp;
            } else {
                index = i;
                nums[i - 1] = nums[i - 1] * 2;
            }
        }
        /* last item in nums will be max number.
        compare it with every other number and if it
        is smaller than any number, return -1 */
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[nums.length - 1] < nums[i])
                return -1;
        }
        // return index of max number
        return index;
    }
    public static void main(String[] args) {
        // int[] nums = {3,6,1,0};
        // int[] nums = {1,2,3,4};
        // int[] nums = {1};
        // int[] nums = {0,1,1,2};
        int[] nums = {1,2,16,35,44,100,27,0};
        int index = dominantIndex(nums);
        System.out.println(index);
    }
}
