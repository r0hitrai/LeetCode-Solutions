class HeightChecker {
    public int heightChecker(int[] heights) {
        // number of wrong indices
        int num = 0;
        // array of expected height order
        int expected[] = new int[heights.length];
        // copy items from heights array to expected array
        System.arraycopy(heights, 0, expected, 0, heights.length);
        // sort expected array using sort()
        sort(expected, 0, expected.length - 1);
        /* compare heights and expected array and
        increment nums for all indices where items
        are different */
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i])
                num++;
        }
        // return total number of different indices
        return num;
    }

    /* merge two subarrays */
    static void merge(int arr[], int left, int mid, int right) {
        /* size of subarrays */
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        /* subarrays */
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];

        /* insert items in subarrays from array */
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + 1 + j];
        // index of first and second subarrays
        int i = 0, j = 0;
        // index of merged subarray
        int k = left;
        /* insert samller item from subarrays into merged array */
        while(i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        /* insert remaining item from left subarray into merged array */
        while(i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        /* insert remaining item from right subarray into merged array */
        while(j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    /* sort array using merge function */
    static void sort(int arr[], int left, int right) {
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
}