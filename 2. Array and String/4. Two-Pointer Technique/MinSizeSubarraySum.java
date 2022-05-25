/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/
public class MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        // min length of subarray
        int length = nums.length;
        // index to reduce sum
        int i = 0;
        // index to increase sum
        int j = 0;
        // sum starts form value of i
        int sum = nums[i];
        // length of subarray
        int count = 1;
        // status of target reached
        boolean isTarget = false;
        /* find sum and length of subarray and
        store min lenght */
        while (true) {
            /* if target reached and subarray length is
            less than previous subarray, then store it */
            if (sum >= target && count <= length) {
                length = count;
                isTarget = true;
            }
            /* if target not reached, add next number,
            increase subarray length and 
            stop when out of array */
            if (sum < target) {
                j++;
                if (j == nums.length)
                    break;
                sum += nums[j];
                count++;
            /* if target reached, subtract item from start
            and reduce subarray length */
            } else {
                sum -= nums[i];
                i++;
                count--;
            }
        }
        /* if target reached, return length
        else return 0 */
        if (isTarget)
            return length;
        else
            return 0;
    }
    public static void main(String[] args) {
        // int target = 7;
        // int[] nums = {2,3,1,2,4,3};
        // int target = 4;
        // int[] nums = {1,4,4};
        // int target = 11;
        // int[] nums = {1,1,1,1,1,1,1,1};
        // int target = 213;
        // int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 15;
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(target, nums));
    }
}
