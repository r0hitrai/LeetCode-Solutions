/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // index of nums1 from back
        int i = nums1.length - 1;
        // index of last item in nums1
        int j = m - 1;
        // index of last item in nums 2
        int k = n - 1;
        // for each item in nums1 and nums2
        while (j >= 0 && k >= 0) {
            // in nums1 item is bigger
            if (nums1[j] > nums2[k]) {
                // store it in back of nums1
                nums1[i] = nums1[j];
                // next item from back in nums1
                j--;
            // if nums2 item is same or bigger
            } else {
                // store it in back of nums1
                nums1[i] = nums2[k];
                // next item from back in nums2
                k--;
            }
            // next place from back in nums1
            i--;
        }
        // for all remaining items in nums2
        while (k >= 0) {
            // store it in back of nums1
            nums1[i] = nums2[k];
            // next place from back in nums1
            i--;
            // next item from back in nums2
            k--;
        }
    }
}
