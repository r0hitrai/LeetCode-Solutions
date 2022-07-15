/*
118.
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.
URL: https://leetcode.com/problems/pascals-triangle/
*/
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        // pascal triangle
        List<List<Integer>> result = new ArrayList<>();
        /* add first row */
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        /* if only 1 row required */
        if (numRows == 1)
            return result;
        /* add second row */
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        result.add(list2);
        /* if only 2 rows required */
        if (numRows == 2)
            return result;
        /* if more than 2 rows required */
        for (int i = 2; i < numRows; i++) {
            // next row
            List<Integer> items = new ArrayList<>();
            // first item is 1
            items.add(1);
            /* from 2nd to last 2nd items */
            for (int j = 1; j < i; j++) {
                // previoud row
                List<Integer> temp = result.get(i - 1);
                /* next item is sum of same and previous 
                 index item */
                int item = temp.get(j - 1) + temp.get(j);
                items.add(item);
            }
            // last item is 1
            items.add(1);
            // add row in result
            result.add(items);
        }
        return result;
    }
    public static void main(String[] args) {
        // int numRows = 5;
        int numRows = 3;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
    }
}
