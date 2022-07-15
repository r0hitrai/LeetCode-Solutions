public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        // left and right index to denote subarray, mid index
        // of subarray
        int left = 0, right = nums.length - 1, mid = 0;
        // while there are elements in subarray
        while (left <= right) {
            // mid index
            mid = (left + right) / 2;
            /* if mid is target, retur mid */
            if(target == nums[mid])
                return mid;
            /* if target is less than mid, go to left 
             * subarray, else go to right subarray
             */
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        /* if target is less than mid, insert it befor mid */
        if (target < nums[mid])
            return mid;
        /* if target is more than mid, insert it at mid */
        else
            return mid + 1;
    }
    public static void main(String[] args) {
        // int[] nums = {1,3,5,6};
        // int target = 7;
        // int[] nums = {1};
        // int target = 2;
        int[] nums = {1,3};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
