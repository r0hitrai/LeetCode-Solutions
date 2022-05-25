/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

1. arr.length >= 3
2. There exists some i with 0 < i < arr.length - 1 such that:
	a. arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
	b. arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    */
    
    public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        // if array length is less than 3 or no strictly increasing or no strictly decreasing
        if (arr.length < 3 || arr[0] >= arr[1] || arr[arr.length - 2] <= arr[arr.length - 1])
            // not mountain
            return false;
        // is peek of the mountain is reached
        boolean isPeeked = false;
        // for every item in array from front
        for (int i = 1; i < arr.length - 2; i++) {
            // if peek is not reached
            if (!isPeeked) {
                // if peek is reached
                if (arr[i] > arr[i + 1])
                    // peek is reached
                    isPeeked = true;
            }
            // if peek is reached
            else {
                // if not strictly decreasing
                if (arr[i] < arr[i + 1])
                    // not a mountain
                    return false;
            }
            // if not strictly increasing or decreasing
            if (arr[i] == arr[i + 1])
                // not a mountain
                return false;
        }
        // mountain
        return true;
    }
}
