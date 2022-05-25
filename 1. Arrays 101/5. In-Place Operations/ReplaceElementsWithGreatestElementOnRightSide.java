/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
*/

class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        // for every item in array from front except last item
        for (int i = 0; i < arr.length - 1;) {
            // set next item's index as max
            int maxI = i + 1;
            // for other items
            for (int j = maxI + 1; j < arr.length; j++) {
                // if the next items index is larger
                if (arr[maxI] < arr[j])
                    // set it as max
                    maxI = j;
            }
            // for all item till max index
            while (i < maxI) {
                // replace item as max item
                arr[i] = arr[maxI];
                // next index
                i++;
            }
        }
        // set last item as -1
        arr[arr.length - 1] = -1;
        // return same array
        return arr;
    }
}