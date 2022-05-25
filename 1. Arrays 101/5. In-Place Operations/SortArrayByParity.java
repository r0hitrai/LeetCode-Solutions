/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
*/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        // front index
        int i = 0;
        // back index
        int j = nums.length - 1;
        // while front index is less than back index
        while (i < j) {
            // if front is odd and back is even
            if (nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                // swap front and back
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // next front
                i++;
                // next back
                j--;
            }
            // if front is even
            if (nums[i] % 2 == 0)
                // next front
                i++;
            // if back is odd
            if (nums[j] % 2 != 0)
                // next back
                j--;
        }
        // return resultant array
        return nums;
    }
}
