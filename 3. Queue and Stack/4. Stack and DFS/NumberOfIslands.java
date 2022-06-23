/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int result = 0;
        // for each row
        for (int i = 0; i < grid.length; i++) {
            // for each item in row
            for (int j = 0; j < grid[i].length; j++) {
                /* if item is 1, mark visited and
                 * call DFS on it, increment result.
                 */
                if (grid[i][j] == '1') {
                    grid[i][j] = 'v';
                    DFS(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    /* performs DFS on current item */
    static void DFS(char[][] grid, int i, int j) {
        /* if next row item is in grid and 1, mark visited and
         * call DFS on it.
         */
        int neighbour = i + 1;
        if (neighbour < grid.length && grid[neighbour][j] == '1') {
            grid[neighbour][j] = 'v';
            DFS(grid, neighbour, j);
        }
        /* if next column item is in grid and 1, mark visited
         * and call DFS on it.
         */
        neighbour = j + 1;
        if (neighbour < grid[i].length && grid[i][neighbour] == '1') {
            grid[i][neighbour] = 'v';
            DFS(grid, i, neighbour);
        }
        /* if previous row item is in grid and 1, mark visited and
         * call DFS on it.
         */
        neighbour = i - 1;
        if (neighbour > -1 && grid[neighbour][j] == '1') {
            grid[neighbour][j] = 'v';
            DFS(grid, neighbour, j);
        }
        /* if previous column item is in grid and 1, mark visited
         * and call DFS on it.
         */
        neighbour = j - 1;
        if (neighbour > -1 && grid[i][neighbour] == '1') {
            grid[i][neighbour] = 'v';
            DFS(grid, i, neighbour);
        }
    }
    public static void main(String[] args) {
        // char[][] grid = {
        //     {'1','1','1','1','0'},
        //     {'1','1','0','1','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','0','0','0'}
        // };
        // char[][] grid = {
        //     {'1','1','0','0','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','1','0','0'},
        //     {'0','0','0','1','1'}
        // };
        // char[][] grid = {{'1','0','1'}};
        char[][] grid = {
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        };
        System.out.println(numIslands(grid));
    }
}