public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        // index of last place of nums
        int last = nums.length - 1;
        // put first max in last place
        putMaxLast(nums, 0, last);
        // first max number
        int max = nums[last];
        // number of max item
        int noMax = 1;
        /* keep putting max item at last and 
        increment noMax only for unique max items,
        do this while noMax is not 3 */
        while (noMax < 3 && last > 0) {
            last--;
            putMaxLast(nums, 0, last);
            if (max != nums[last]) {
                noMax++;
                max = nums[last];
            }
        }
        /* if third max exists, return it,
        otherwise, return first max */
        if (noMax == 3)
            return max;
        else
            return nums[nums.length - 1];
    }
    /* put max item at last */
    static void putMaxLast(int arr[], int left, int right) {
        /* compare adjacent items and place max of them
        in right place */
        for (int i = left; i < right; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}
