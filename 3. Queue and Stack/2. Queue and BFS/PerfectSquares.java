/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class PerfectSquares {
    public static int numSquares(int n) {
        // least numbers required
        int result = 0;
        /* array of perfect squares less than n */
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        perfectSquares.add(1);
        for (int i = 2; i * i <= n; i++)
            perfectSquares.add(i * i);
        /* queue having sum of perfect squares at levels */
        Queue<Integer> queue = new LinkedList<>();
        for (int i = perfectSquares.size() - 1; i > -1; i--)
            queue.offer(perfectSquares.get(i));
        // sum of perfect squares
        int sum = 0;
        // until queue is empty
        while (queue.peek() != null) {
            // next level
            result++;
            // number of items at this level
            int size = queue.size();
            // for each sum at this level
            for (int i = 0; i < size; i++) {
                // first item
                sum = queue.poll();
                /* if target reached, return */
                if (sum == n)
                    return result;
                /* insert sum with every perfect square in the queue */
                for (int j = 0; j < perfectSquares.size(); j++) {
                    int item = sum + perfectSquares.get(j);
                    /* if target reached, return */
                    if (item == n)
                        return result + 1;
                    /* stop when sum is more than targer */
                    if (item > n)
                        break;
                    queue.offer(item);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 7168;
        System.out.println(numSquares(n));
    }
}
