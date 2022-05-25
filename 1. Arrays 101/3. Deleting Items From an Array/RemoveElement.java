/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
*/

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // index from front
        int i = 0;
        // index from back
        int j = nums.length - 1;
        // for each item
        while (i <= j) {
            // continue while front item is not val
            if (nums[i] != val)
                i++;
            // when back item is val
            else {
                // continue till back items is val
                if (nums[j] == val)
                    j--;
                // when back item is not val
                else {
                    // copy back item in front
                    nums[i] = nums[j];
                    i++;
                    j--;
                }
            }
        }
        // return number of items
        return i;
    }
}