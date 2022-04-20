public class RemoveElement {
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
