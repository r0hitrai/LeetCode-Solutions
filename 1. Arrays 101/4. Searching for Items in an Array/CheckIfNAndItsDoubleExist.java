/*
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

1. i != j
2. 0 <= i, j < arr.length
3. arr[i] == 2 * arr[j]
*/

class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        // half of number
        int h = 0;
        // double of number
        int d = 0;
        // for every item in array from front
        for (int i = 0; i < arr.length; i++) {
            // if current number is even
            if (arr[i] % 2 == 0) {
                // get half of current number
                h = arr[i] / 2;
                // get double of current number
                d = arr[i] * 2;
                // for every other item in array
                for (int j = i + 1; j < arr.length; j++) {
                    // if other number is half or double of current number
                    if (arr[j] == h || arr[j] == d)
                        // pair exits
                        return true;
                }
            }
            // if current number is odd
            else {
                // get double of currrent number
                d = arr[i] * 2;
                // for every other item in array
                for (int j = i + 1; j < arr.length; j++) {
                    // if other number is double of current number
                    if (arr[j] == d)
                        // pair exists
                        return true;
                }
            }
        }
        // no pair exists
        return false;
    }
}