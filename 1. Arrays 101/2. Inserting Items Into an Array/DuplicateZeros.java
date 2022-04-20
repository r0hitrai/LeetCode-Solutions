class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        // no of 0s
        int no0s = 0;
        // for every item in arr
        for (int item : arr) {
            // if item is 0
            if (item == 0)
                // increment no0s
                no0s++;
        }
        // if there are no 0 or every element is 0
        if (no0s == 0 || no0s == arr.length)
            // arr is already done, return
            return;
        // from back of arr
        for (int i = arr.length - 1; i >= 0; i--) {
            // if shifting of item due to previous 0s is not outside array
            if (i + no0s <= arr.length - 1)
                // shift item to that place
                arr[i + no0s] = arr[i];
            // if one 0 is done
            if (arr[i] == 0) {
                // decrement no0s
                no0s--;
                // if shifting of item due to previous 0s is not outside array
                if (i + no0s <= arr.length - 1)
                    // shift item to that place
                    arr[i + no0s] = arr[i];
            }
        }
    }
}