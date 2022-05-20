/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
*/
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        // size of the matrix
        int m = mat.length, n = mat[0].length;
        // array of all items in diagonal order
        int[] result = new int[m * n];
        // indices for traversing matrix
        int i = 0, j = 0;
        // changing increment-decrement operation on indices
        boolean alt = true;
        // for each item in matrix
        for (int r = 0; r < m * n; r++) {
            // store item in result
            result[r] = mat[i][j];
            /* increment-decrement index based on status */
            if (alt) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
            /* move to adjacent row and change the 
            increment-decrement operation */
            if (i < 0) {
                i++;
                alt = false;
                if (j == n) {
                    i++;
                    j--;
                }
            }
            /* move to adjacent column and change the 
            increment-decrement operation */
            if (j < 0) {
                j++;
                alt = true;
                if (i == m) {
                    i--;
                    j++;
                }
            }
            if (j == n) {
                j--;
                i += 2;
                alt = false;
            }
            if (i == m) {
                i--;
                j += 2;
                alt = true;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        // int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{2,3}};
        // int[][] mat = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        // int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] result = findDiagonalOrder(mat);
        for (int item : result)
            System.out.print(item + ", ");
        System.out.println();
    }
}