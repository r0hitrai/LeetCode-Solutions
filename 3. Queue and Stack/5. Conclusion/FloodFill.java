/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
*/
import java.util.Queue;
import java.util.LinkedList;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // start pixel color
        int sColor = image[sr][sc];
        /* if starting color is same as fill color, then no change required */
        if (sColor == color)
            return image;
        // queue of connected pixels
        Queue<Integer> queue = new LinkedList<>();
        /* start pixel */
        queue.offer(sr);
        queue.offer(sc);
        // for all connected pixels
        while (queue.size() != 0) {
            /* get one pixel */
            int row = queue.poll();
            int col = queue.poll();
            // color it
            image[row][col] = color;
            /* top connected pixel */
            if (row - 1 > -1 && image[row-1][col] == sColor) {
                queue.offer(row-1);
                queue.offer(col);
            }
            /* right connected pixel */
            if (col + 1 < image[row].length && image[row][col+1] == sColor) {
                queue.offer(row);
                queue.offer(col+1);
            }
            /* bottom conneted pixel */
            if (row + 1 < image.length && image[row+1][col] == sColor) {
                queue.offer(row+1);
                queue.offer(col);
            }
            /* left connected pixel */
            if (col - 1 > -1 && image[row][col-1] == sColor) {
                queue.offer(row);
                queue.offer(col-1);
            }
        }
        return image;
    }
    public static void main(String[] args) {
        // int[][] image = {
        //     {1,1,1},
        //     {1,1,0},
        //     {1,0,1}
        // };
        // int sr = 1;
        // int sc = 1;
        // int color = 2;
        int[][] image = {
            {0,0,0},
            {0,0,0}
        };
        int sr = 0;
        int sc = 0;
        int color = 0;
        int[][] result = floodFill(image, sr, sc, color);
        for (int[] items : result) {
            for (int item : items)
                System.out.print(item + ", ");
            System.out.println();
        }
    }
}
