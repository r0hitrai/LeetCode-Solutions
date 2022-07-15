/*
695.
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*/
import java.util.Queue;
import java.util.LinkedList;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        // dimension of grid
        int m = grid.length, n = grid[0].length;
        // maximum area of island
        int maxArea = 0;
        // for each cell
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                /* if current cell is 1, find area for this 
                 * island and store maximum area
                 */
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
        return maxArea;
    }
    /* area of island */
    static int areaOfIsland(int[][] grid, int row, int col) {
        // dimension of grid
        int m = grid.length, n = grid[0].length;
        // area of island
        int area = 0;
        // to store neighbours
        Queue<Integer> queue = new LinkedList<>();
        /* add starting cell in queue */
        queue.offer(row);
        queue.offer(col);
        // mark current cell as visited
        grid[row][col] = -1;
        // while there are neighbours
        while (!queue.isEmpty()) {
            area++;
            /* get current cell */
            row = queue.poll();
            col = queue.poll();
            /* if neighbour is at top, add in queue */
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                queue.offer(row - 1);
                queue.offer(col);
                // mark it as visited
                grid[row - 1][col] = -1;
            }
            /* if neighbour is at right, add in queue */
            if (col + 1 < n && grid[row][col + 1] == 1 ) {
                queue.offer(row);
                queue.offer(col + 1);
                // mark it as visited
                grid[row][col + 1] = -1;
            }
            /* if neighbour is at bottom, add in queue */
            if (row + 1 < m && grid[row + 1][col] == 1 ) {
                queue.offer(row + 1);
                queue.offer(col);
                // mark it as visited
                grid[row + 1][col] = -1;
            }
            /* if neighbour is at left, add in queue */
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                queue.offer(row);
                queue.offer(col - 1);
                // mark it as visited
                grid[row][col - 1] = -1;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        // int[][] grid = {
        //     {0,0,1,0,0,0,0,1,0,0,0,0,0},
        //     {0,0,0,0,0,0,0,1,1,1,0,0,0},
        //     {0,1,1,0,1,0,0,0,0,0,0,0,0},
        //     {0,1,0,0,1,1,0,0,1,0,1,0,0},
        //     {0,1,0,0,1,1,0,0,1,1,1,0,0},
        //     {0,0,0,0,0,0,0,0,0,0,1,0,0},
        //     {0,0,0,0,0,0,0,1,1,1,0,0,0},
        //     {0,0,0,0,0,0,0,1,1,0,0,0,0}
        // };
        // int[][] grid = {
        //     {0,0,0,0,0,0,0,0,0,0,0}
        // };
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
