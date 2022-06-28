/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */

/* Definition for singly-linked list. */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        /* if linked list is empty, no cycle */
        if (head == null)
            return false;
        // slow pointer
        ListNode slow = head;
        // fast pointer
        ListNode fast = head;
        // while fast pointer doesn't reach to end
        while (fast.next != null && fast.next.next != null) {
            // slow pointer moves ahead one step
            slow = slow.next;
            // fast pointer moves ahead two steps
            fast = fast.next.next;
            /* if fast catches up to slow again, cycle exists */
            if (fast == slow)
                return true;
        }
        // if fast reaches to end, cycle doesn't exists
        return false;
    }
    public static void main(String[] args) {
        // ListNode node0 = new ListNode(3);
        // ListNode node1 = new ListNode(2);
        // ListNode node2 = new ListNode(0);
        // ListNode node3 = new ListNode(4);
        // node0.next = node1;
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node1;

        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // ListNode node0 = new ListNode(1);
        // ListNode node1 = new ListNode(2);
        // node0.next = node1;
        // node1.next = node0;

        // ListNode node0 = new ListNode(1);

        ListNode head = node0;
        System.out.println(hasCycle(head));
    }
}