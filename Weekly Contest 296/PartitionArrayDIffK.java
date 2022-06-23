/*
2294. Partition Array Such That Maximum Difference Is K
Difficulty:Medium
You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.

Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
*/
import java.util.ArrayList;
import java.util.Comparator;

public class PartitionArrayDIffK {
    public static int partitionArray(int[] nums, int k) {
        int count = 0;
        int size = nums.length;
        /* store sorted nums in ascending order */
        ArrayList<Integer> numsSorted = new ArrayList<>();
        for (int item : nums)
            numsSorted.add(item);
        numsSorted.sort(Comparator.naturalOrder());
        // index from back, for each end of subsequenece
        int i = size - 1, j = size - 1;
        // for all items
        while (j > -1) {
            /* if end difference crosses target, subsequenece found, start for next sequence */
            if (numsSorted.get(i) - numsSorted.get(j) > k) {
                count++;
                i = j;
            // next item
            } else 
                j--;
        }
        return count + 1;
    }
    public static void main(String[] args) {
        // int[] nums = {3,6,1,2,5};
        // int k = 2;
        // int[] nums = {1,2,3};
        // int k = 1;
        int[] nums = {2,2,4,5};
        int k = 0;
        System.out.println(partitionArray(nums, k));
    }
}
