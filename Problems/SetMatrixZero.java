/*
73.
Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
URL: https://leetcode.com/problems/set-matrix-zeroes/
*/
public class SetMatrixZero {
    public static void setMatrixZero(int[][] matrix) {
        // number of rows
        int m = matrix.length;
        // numbre of columns
        int n = matrix[0].length;
        // is 0th column is 0 or not
        boolean isCol0 = false;
        // for each row
        for (int i = 0; i < m; i++) {
            /* if any item of 0th column is 0,
            then 0th column is will be 0 */
            if (matrix[i][0] == 0)
                isCol0 = true;
            // for each column except 0th
            for (int j = 1; j < n; j++) {
                /* if item is 0, set its first row
                and column items to 0 */
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // for each row, from last
        for (int i = m - 1; i > -1; i--) {
            // for each column from last, except 0th
            for (int j = n - 1; j > 0; j--) {
                /* if any of first row or column item is 0,
                set its value to 0 */
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            /* if 0th column is 0,
            set its items to zero */
            if (isCol0)
                matrix[i][0] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        // int[][] matrix = {
        //     {0,1,2,0},
        //     {3,4,5,2},
        //     {1,3,1,5}
        // };
        setMatrixZero(matrix);
        for (int[] row : matrix) {
            for (int item : row)
                System.out.print(item + ", ");
            System.out.println();
        }
    }
}