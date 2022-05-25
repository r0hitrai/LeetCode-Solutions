/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // non-zero number index
        int i = 0;
        // array index
        int j = 0;
        // for every item in array
        while (j < nums.length) {
            // if non-zero number
            if (nums[j] != 0)
                // move it to front
                nums[i++] = nums[j];
            // next item
            j++;
        }
        // for remaining items
        while (i < nums.length)
            // set it as 0
            nums[i++] = 0;
    }
}
