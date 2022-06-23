/*
2293. Min Max Game
Difficulty:Easy
You are given a 0-indexed integer array nums whose length is a power of 2.

Apply the following algorithm on nums:

    1. Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
    2. For every even index i where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
    3. For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
    4. Replace the array nums with newNums.
    5. Repeat the entire process starting from step 1.
Return the last number that remains in nums after applying the algorithm.
*/
public class MinMaxGame {
    public static int minMaxGame(int[] nums) {
        int n = nums.length;
        /* return first item if only one item */
        if (n == 1)
            return nums[0];
        // new array of half size of nums
        int newSize = n / 2;
        // new array
        int[] newNums = null;
        // until new array size becomes 1
        while (newSize >= 1) {
            // new array size at each level will
            // be half than previous level
            newNums = new int[newSize];
            // for each item in new array
            for (int i = 0; i < newSize; i++) {
                /* even index */
                if (i % 2 == 0) {
                    // enter minimum of previous level pairs
                    if (nums[2 * i] < nums[2 * i + 1])
                        newNums[i] = nums[2 * i];
                    else
                        newNums[i] = nums[2 * i + 1];
                /* odd index */
                } else {
                    // enter maximum of previous level pairs
                    if (nums[2 * i] > nums[2 * i + 1])
                        newNums[i] = nums[2 * i];
                    else
                        newNums[i] = nums[2 * i + 1];
                }
            }
            // update nums by newNums
            nums = newNums;
            // new size is half
            newSize /= 2;
        }
        return newNums[0];
    }
    public static void main(String[] args) {
        // int[] nums = {1,3,5,2,4,8,2,2};
        int[] nums = {3};
        System.out.println(minMaxGame(nums));
    }
}