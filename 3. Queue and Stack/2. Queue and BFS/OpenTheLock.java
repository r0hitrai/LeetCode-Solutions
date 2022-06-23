/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        // min number of steps
        int result = 0;
        // neighbours
        Queue<String> queue = new LinkedList<>();
        // first lock
        queue.offer("0000");
        // set of visited locks, no duplicates
        Set<String> visited = new HashSet<>();
        /* set deadends as visited locks */
        for (String item : deadends)
            visited.add(item);
        // while neighbours exists
        while (queue.peek() != null) {
            // number of current lock neighbours
            int size = queue.size();
            // for each neighbour
            for (int l = 0; l < size; l++) {
                // remove neighbour from queue
                String number = queue.poll();
                /* if target reached, return steps */
                if (number.equals(target))
                    return result;
                /* if lock visited, skip
                else move forward */
                if (!visited.add(number))
                    continue;
                // for each lock number
                for (int i = 0; i < 4; i++) {
                    // lock sequence
                    StringBuilder item = new StringBuilder(number);
                    // one character of lock
                    char c = item.charAt(i);
                    /* if 9, round to 0,
                    else increment */
                    if (c == '9')
                        item.setCharAt(i, '0');
                    else
                        item.setCharAt(i, ++c);
                    // insert in queue
                    queue.offer(item.toString());
                    // lock sequence
                    item = new StringBuilder(number);
                    // one character of lock
                    c = item.charAt(i);
                    /* if 0, round to 9,
                    else decrement */
                    if (c == '0')
                        item.setCharAt(i, '9');
                    else
                        item.setCharAt(i, --c);
                    // add to queue
                    queue.offer(item.toString());
                }
            }
            // next step
            result++;
        }
        return -1;
    }
    public static void main(String[] args) {
        // String[] deadends = {"0201","0101","0102","1212","2002"};
        // String target = "0202";
        // String[] deadends = {"8888"};
        // String target = "0009";
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }
}
