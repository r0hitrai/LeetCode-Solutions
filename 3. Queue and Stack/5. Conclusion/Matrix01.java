/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/
import java.util.Queue;
import java.util.LinkedList;

public class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        // number of rows
        int m = mat.length;
        // number of columns
        int n = mat[0].length;
        // maximum distance
        int MAX_DIST = m + n;
        // array of minimum distance
        int[][] distance = new int[m][n];
        // queue for neighbours
        Queue<Integer> queue = new LinkedList<>();
        /* for each cell, if 0, add to queue and 
        update distance, if not 0, update distance */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i);
                    queue.offer(j);
                    distance[i][j] = 0;
                } else
                    distance[i][j] = MAX_DIST;
            }
        }
        // new distance
        int dist = 0;
        // while queue is not empty
        while (queue.size() != 0) {
            // increase distance
            dist++;
            // number of neighbours
            int length = queue.size() / 2;
            // for each neighbour
            for (int i = 0; i < length; i++) {
                /* get first cell */
                int row = queue.poll();
                int col = queue.poll();
                // mark as visited
                mat[row][col] = 0;
                /* top neighbour if not visited*/
                if (row - 1 > -1 && mat[row-1][col] != 0) {
                    /* if new distance is smaller, add 
                    cell in queue and update distance */
                    if (dist < distance[row-1][col]) {
                        queue.offer(row-1);
                        queue.offer(col);
                        distance[row-1][col] = dist;
                    }
                }
                /* right neighbour if not visited*/
                if (col + 1 < n && mat[row][col+1] != 0) {
                    /* if new distance is smaller, add 
                    cell in queue and update distance */
                    if (dist < distance[row][col+1]) {
                        queue.offer(row);
                        queue.offer(col+1);
                        distance[row][col+1] = dist;
                    }
                }
                /* bottom neighbour if not visited*/
                if (row + 1 < m && mat[row+1][col] != 0) {
                    /* if new distance is smaller, add 
                    cell in queue and update distance */
                    if (dist < distance[row+1][col]) {
                        queue.offer(row+1);
                        queue.offer(col);
                        distance[row+1][col] = dist;
                    }
                }
                /* left neighbour if not visited */
                if (col - 1 > -1 && mat[row][col-1] != 0) {
                    /* if new distance is smaller, add 
                    cell in queue and update distance */
                    if (dist < distance[row][col-1]) {
                        queue.offer(row);
                        queue.offer(col-1);
                        distance[row][col-1] = dist;
                    }
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        // int[][] mat = {
        //     {0,0,0},
        //     {0,1,0},
        //     {0,0,0}
        // };
        // int[][] mat = {
        //     {0,0,0},
        //     {0,1,0},
        //     {1,1,1}
        // };
        // int[][] mat = {
        //     {0,0,0},
        //     {0,1,0},
        //     {1,1,1},
        //     {1,1,1}
        // };
        // int[][] mat = {
        //     {1,1,1},
        //     {1,1,1},
        //     {1,1,0}
        // };
        // int[][] mat = {
        //     {0,1,0},
        //     {0,1,0},
        //     {0,1,0},
        //     {0,1,0},
        //     {0,1,0}
        // };
        // int[][] mat = {
        //     {0,1,0,1,1},
        //     {1,1,0,0,1},
        //     {0,0,0,1,0},
        //     {0,0,0,1,0},
        //     {1,0,1,1,1},
        //     {1,0,0,0,1}
        // };
        int[][] mat = {
            {1,1,1,1,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1},
{1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1},
{1,1,1,1,0,1,0,0,1,1,0,1,1,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,1,1},
{1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,1},
{0,1,0,0,1,0,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1},
{1,0,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,1,0},
{1,1,0,1,1,0,0,0,1,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1},
{1,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1},
{0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,0,1,0,1},
{1,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,1},
{1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,1,1,1,0},
{1,1,1,1,0,1,0,0,0,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1},
{0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,0,0,0,1},
{0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,1,1},
{1,1,1,1,0,0,1,1,1,0,0,1,1,0,1,1,1,0,0,1,1,0,1,0,0,0,0,1,1,1},
{1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,1,0,0,0},
{1,1,0,1,1,0,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,0,1,0,1},
{1,0,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0,1,0,0,1,1,1,1,1,0},
{1,1,0,1,0,1,1,0,0,1,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1},
{1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,1,1,1,0,1,1,0,1,0,1,1,0},
{1,0,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1},
{0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,1,0,0,1,0,1,1,0,1,1,0,1,0,1},
{1,1,1,0,1,1,1,0,0,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1},
{1,1,0,0,1,1,1,1,0,0,1,0,0,1,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,1},
{0,0,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,0},
{1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,0,0,1,1,1},
{1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,0,1,1,0,0,1,1,0},
{1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1},
{0,1,1,0,1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,1,1,0,1,0}
        };
        int[][] result = updateMatrix(mat);
        System.out.println("\nresult : ");
        for (int[] items : result) {
            for (int item : items)
                System.out.print(item + ", ");
            System.out.println();
        }
    }
}
