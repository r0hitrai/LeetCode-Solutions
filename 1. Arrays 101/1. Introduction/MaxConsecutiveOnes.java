class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        // number of 1s, maximum number of 1s
        int no1s = 0, max = 0;
        // for every item in nums
        for (int i = 0; i < nums.length; i++) {
            // if item is 1
            if (nums[i] == 1) {
                // increment no1s
                no1s++;
                // if no1s is greater than current max
                if (no1s > max)
                    // update max with no1s
                    max = no1s;
            }
            // if item is not 1
            else
                // reset no1s to 0
                no1s = 0;
        }
        // return result
        return max;
    }
}