public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        // resultant array
        int result[] = new int[nums.length];
        // for each item in nums
        for (int i = 0; i < nums.length; i++)
            // square it and store it in nums
            nums[i] *= nums[i];
        // nums index from front
        int i = 0;
        // nums index from back
        int j = nums.length - 1;
        // result index from back
        int k = nums.length - 1;
        // for all places in result
        while (k >= 0) {
            // if front item is bigger than back item in nums
            if (nums[i] > nums[j]) {
                // store in result back
                result[k] = nums[i];
                // next item from front in nums
                i++;
            // if back item is same or bigger than front item in nums
            } else {
                // store it in result back
                result[k] = nums[j];
                // next item from back in nums
                j--;
            }
            // next place from back in result
            k--;
        }
        // return result array containing square of
        // nums in non-decreasing order
        return result;
    }
}
