/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
*/

import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // array of nums size
        int temp[] = new int[nums.length];
        /* store 1 at the index - 1 of temp
        same as the item in nums */
        for (int item : nums)
            temp[item - 1] = 1;
        // list containing disappeared numbers
        List<Integer> result = new ArrayList<Integer>();
        /* add index + 1 number in result from temp
        whose value is not 1 */
        for (Integer i = 0; i < nums.length; i++) {
            if (temp[i] != 1)
                result.add(i + 1);
        }
        // return result list containig
        // all disappeared numbers
        return result;
    }
}
