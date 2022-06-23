/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean result = true;
        // visited rooms
        int[] visited = new int[rooms.size()];
        // queue for keys in a room
        Queue<Integer> queue = new LinkedList<>();
        // key
        int key = 0;
        // add room 0 in queue
        queue.offer(key);
        // while there are keys in queue
        while (queue.size() != 0) {
            // get first key
            key = queue.poll();
            // unlock room
            visited[key] = 1;
            // get all the keys in that room
            List<Integer> keys = rooms.get(key);
            /* for all keys, if room is not visited,
             * add it in queue.
             */
            for (int i = 0; i < keys.size(); i++) {
                if (visited[keys.get(i)] != 1) {
                    queue.offer(keys.get(i));
                }
            }
        }
        /* if any room is not visited, result is flase */
        for (int item : visited)
            if (item == 0)
                result = false;
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> keys1 = new ArrayList<>();
        keys1.add(1);
        rooms.add(keys1);
        List<Integer> keys2 = new ArrayList<>();
        keys2.add(2);
        rooms.add(keys2);
        List<Integer> keys3 = new ArrayList<>();
        keys3.add(3);
        rooms.add(keys3);
        List<Integer> keys4 = new ArrayList<>();
        rooms.add(keys4);
        // List<List<Integer>> rooms = new ArrayList<>();
        // List<Integer> keys1 = new ArrayList<>();
        // keys1.add(1);
        // keys1.add(3);
        // rooms.add(keys1);
        // List<Integer> keys2 = new ArrayList<>();
        // keys2.add(3);
        // keys2.add(0);
        // keys2.add(1);
        // rooms.add(keys2);
        // List<Integer> keys3 = new ArrayList<>();
        // keys3.add(2);
        // rooms.add(keys3);
        // List<Integer> keys4 = new ArrayList<>();
        // keys4.add(0);
        // rooms.add(keys4);
        System.out.println(canVisitAllRooms(rooms));
    }
}
