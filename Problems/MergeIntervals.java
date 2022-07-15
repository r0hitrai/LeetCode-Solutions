/*
 56.
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 URL : https://leetcode.com/problems/merge-intervals/
 */
import java.util.Stack;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // sort intervals based on start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // stack to store merged intervals
        Stack<Integer> stack = new Stack<>();
        // for each interval in intervals
        for (int[] interval : intervals) {
            /* if first interval or non-overlapping interval,
             * add in stack
             */
            if (stack.isEmpty() || interval[0] > stack.peek()) {
                stack.push(interval[0]);
                stack.push(interval[1]);
            /* if overlapping interval, add maximum end of 
             * previous and current interval
             */
            } else
                stack.push(Integer.max(stack.pop(), interval[1]));
        }
        // resultant array of size half of stack
        int[][] result = new int[stack.size() / 2][2];
        /* copy stack items in result from back */
        for (int i = result.length - 1; i >= 0; i--) {
            result[i][1] = stack.pop();
            result[i][0] = stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };
        // int[][] intervals = {
        //     {2, 3},
        //     {4, 5},
        //     {6, 7},
        //     {8, 9},
        //     {1, 10}
        // };
        // int[][] intervals = {
        //     {1, 4},
        //     {4, 5}
        // };
        // int[][] intervals = {
        //     {1, 4},
        //     {0, 4}
        // };
        // int[][] intervals = {
        //     {1, 4},
        //     {0, 1}
        // };
        // int[][] intervals = {
        //     {1, 4},
        //     {2, 3}
        // };
        // int[][] intervals = {
        //     {1, 4},
        //     {0, 0}
        // };
        // int[][] intervals = {
        //     {0, 9}
        // };
        int[][] result = merge(intervals);
        for (int[] items : result) {
            System.out.print("(");
            for (int item : items)
                System.out.print(item + ",");
            System.out.print("),");
        }
        System.out.println();
    }
}