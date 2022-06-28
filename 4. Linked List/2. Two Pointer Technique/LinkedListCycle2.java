/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
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

public class LinkedListCycle2 {
    public static ListNode detectCycle(ListNode head) {
        /* if linked list is empty, no cycle */
        if (head == null)
            return null;
        // cycle status
        boolean isCycle = false;
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
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        /* if cycle exists, move head and slow pointer 
        till the meet at start of cycle */
        if (isCycle) {
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
        /* if cycle doesn't exists, return null */
        } else 
            return null;
        // if fast reaches to end, cycle doesn't exists
        return head;
    }
    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        // ListNode node0 = new ListNode(3);
        // ListNode node1 = new ListNode(2);
        // ListNode node2 = new ListNode(0);
        // ListNode node3 = new ListNode(4);
        // node0.next = node1;
        // node1.next = node2;
        // node2.next = node3;

        // ListNode node0 = new ListNode(1);
        // ListNode node1 = new ListNode(2);
        // node0.next = node1;
        // node1.next = node0;

        // ListNode node0 = new ListNode(1);

        ListNode head = node0;
        System.out.println(detectCycle(head));
    }
}
