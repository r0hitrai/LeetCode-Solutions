/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it
*/
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        // Pascal's Triangle row
        List<Integer> result = new ArrayList<>();
        // 0th row
        result.add(1);
        /* return if 0th row required */
        if (rowIndex == 0)
            return result;
        // 1th row
        result.add(1);
        /* return if 1st row required */
        if (rowIndex == 1)
            return result;
        // number of items to calculate
        int j = 1;
        // for rest of the rows
        for (int i = 2; i <= rowIndex; i++) {
            /* calculate items */
            for (int k = 0; k < j; k++) {
                // item is sum of first two items
                int item = result.get(0) + result.get(1);
                // add item in result
                result.add(item);
                // remove first item
                result.remove(0);
            }
            // add last item 1
            result.add(1);
            // increase number of items
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        int rowIndex = 5;
        // int rowIndex = 0;
        // int rowIndex = 1;
        System.out.println(getRow(rowIndex));
    }
}