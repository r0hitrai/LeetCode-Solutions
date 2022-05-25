/*
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
*/
public class ArrayPartition1 {
    public static int arrayPairSum(int[] nums) {
        // maximum sum of minimum of pairs
        int maxSum = 0;
        // sort nums in ascending order
        sort(nums, 0, nums.length - 1);
        /* take pairs from back as it will give max sum from their min items */
        for (int i = nums.length - 1, j = nums.length - 2; i > -1 && j > -1; i -= 2, j -= 2) {
            if (i < j)
                maxSum += nums[i];
            else
                maxSum += nums[j];
        }
        return maxSum;
    }
    /* merge two subarrays */
    static void merge(int[] arr, int left, int mid, int right) {
        /* size of subarrays */
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        /* subarrays */
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        /* insert items in subarrays from array */
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + 1 + j];
        // index of subarrays
        int i = 0, j = 0;
        // index of merged subarray
        int k = left;
        /* insert smaller item from subarrays into merged array */
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        /* insert remaining items from subarrays into merged array */
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    /* sort array using merge function */
    static void sort(int[] arr, int left, int right) {
        // if more than one item
        if (left < right) {
            // index of middle item
            int mid = left + (right - left) / 2;
            /* sort first and second half */
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            // merge them
            merge(arr, left, mid, right);
        }
    }
    public static void main(String[] args) {
        // int[] nums = {1,4,3,2};
        int[] nums = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
}
