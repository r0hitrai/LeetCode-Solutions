/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

URL : https://leetcode.com/problems/two-sum/
*/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //  indices of the two numbers add up to target
        int[] result = new int[2];
        /* sum one item with every other item, if sum reaches
         * target, return those indices
         */
        for (int i = 0; i < nums.length; i++) {
            /* if i value is greater than target, skip */
            if (nums[i] > target)
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                /* if j value is greater than target, skip */
                if (nums[j] > target)
                    continue;
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // int[] nums = {2,7,11,15};
        // int target = 9;
        // int[] nums = {3,2,4};
        // int target = 6;
        int[] nums = {3,3};
        int target = 6;

        int[] result = twoSum(nums, target);
        for (int item : result)
            System.out.print(item + ", ");
        System.out.println();
    }
}
