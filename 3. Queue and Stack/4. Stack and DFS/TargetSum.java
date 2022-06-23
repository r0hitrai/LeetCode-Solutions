/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
*/
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        return DFS(nums, 0, 0, target);
    }
    /* calculating total sums */
    static int DFS(int[] nums, int index, int sum, int target) {
        /* if total sum is target, count it
         * else don't count it
         */
        if (index == nums.length) {
            if (sum == target)
                return 1;
            else
                return 0;
        }
        // call DFS for plus and minus
        return DFS(nums, index + 1, sum + nums[index], target) + DFS(nums, index + 1, sum - nums[index], target);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        // int[] nums = {1};
        // int target = 1;
        // int[] nums = {1};
        // int target = 2;
        System.out.println(findTargetSumWays(nums, target));
    }
}
