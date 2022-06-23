/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        // number of islands
        int result = 0;
        // number of rows
        int m = grid.length;
        // Queue for storing neighbours
        Queue<Integer> queue = new LinkedList<>();
        // for every row
        for (int i = 0; i < m; i++) {
            // number of columns in this row
            int n = grid[i].length;
            // for every column
            for (int j = 0; j < n; j++) {
                /* if item is 0 or v (visited),
                then skip */
                if (grid[i][j] == '0' || grid[i][j] == 'v')
                    continue;
                // increase number of islands
                result++;
                // insert row number in queue
                queue.offer(i);
                // insert column number in queue
                queue.offer(j);
                // while there is item in queue
                while(queue.peek() != null) {
                    // pop row number
                    int p = queue.poll();
                    // pop column number
                    int q = queue.poll();
                    /* if already visited,
                    then skip */
                    if (grid[p][q] == 'v')
                        continue;
                    // mark this item as visited
                    grid[p][q] = 'v';
                    /* if adjacent bottom item is 1,
                    then insert it in queue */
                    if (p + 1 < m) {
                        if (grid[p + 1][q] == '1') {
                            queue.offer(p + 1);
                            queue.offer(q);
                        }
                    }
                    /* if adjacent right item is 1,
                    then insert it in queue */
                    if (q + 1 < n) {
                        if (grid[p][q + 1] == '1') {
                            queue.offer(p);
                            queue.offer(q + 1);
                        }
                    }
                    /* if adjacent top item is 1,
                    then insert it in queue */
                    if (p - 1 > -1) {
                        if (grid[p - 1][q] == '1') {
                            queue.offer(p - 1);
                            queue.offer(q);
                        }
                    }
                    /* if adjacent left item is 1,
                    then insert it in queue */
                    if (q - 1 > -1) {
                        if (grid[p][q - 1] == '1') {
                            queue.offer(p);
                            queue.offer(q - 1);
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        // char[][] grid = {
        //     {'1','1','0','0','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','1','0','0'},
        //     {'0','0','0','1','1'}
        // };
        // char[][] grid = {
        //     {'1','1','1'},
        //     {'0','1','0'},
        //     {'1','1','1'}
        // };
        // char[][] grid = {
        //     {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
        //     {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
        //     {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
        //     {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
        //     {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        //     {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        // };
        // char[][] grid = {{'1','1'}, {'1'}};
        System.out.println(numIslands(grid));
        // int m = grid.length;
        // int n = grid[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++)
        //         System.out.print(grid[i][j] + ", ");
        //     System.out.println();
        // }
    }
}