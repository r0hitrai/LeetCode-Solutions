public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // unique number index
        int i = 0;
        // array index
        int j = 0;
        // for every item in array
        while (j < nums.length) {
            // if unique number
            if (nums[i] != nums[j])
                // then copy it in next unique number index
                nums[++i] = nums[j];
            // next item
            j++;
        }
        // return number of unique numbers
        return i + 1;
    }
}
