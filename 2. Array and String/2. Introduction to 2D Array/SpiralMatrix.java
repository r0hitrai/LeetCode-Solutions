/*
Given an m x n matrix, return all elements of the matrix in spiral order.
*/
import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        // size of the matrix
        int m = matrix.length, n = matrix[0].length;
        // List of items in of matrix in spiral order
        List<Integer> result = new ArrayList<>();
        // starting index
        int k = 0, l = 0;
        // index for traversing
        int i = k, j = l;
        // select a operation
        int op = 1;
        // number of items in matrix
        int items = m * n;
        // for each item in matrix
        for (int r = 0; r < items; r++) {
            // add item to result
            result.add(matrix[i][j]);
            /* four operations */
            if (op == 1)
                j++;
            else if (op == 2)
                i++;
            else if (op == 3)
                j--;
            else if (op == 4)
                i--;
            /* if row is done, move to column downward */
            if (j == n) {
                j--;
                i++;
                op = 2;
            }
            /* if column is done, move to row backward */
            if (i == m) {
                i--;
                j--;
                op = 3;
            }
            /* if row is done, move to column upward */
            if (j < l) {
                j++;
                i--;
                op = 4;
            }
            /* if back to starting index, move to inner
            matrix excluding outer border and repeat */
            if (i == k && j == l) {
                k++;
                l++;
                i = k;
                j = l;
                m -= 1;
                n -= 1;
                op = 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        List<Integer> result = spiralOrder(matrix);
        for (int item : result)
            System.out.print(item + ", ");
        System.out.println();
    }
}
