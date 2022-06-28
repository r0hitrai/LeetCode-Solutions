/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /* slow pointer for deleting,
         * fast pointer for traversing to end
         */
        ListNode slow = head, fast = head;
        /* move fast pointer n steps ahead,
         * so that slow pointer will point 
         * at previous node of target node
         */
        for (int i = 0; i < n; i++) {
            // move fast pointer to next node
            fast = fast.next;
            /* if fast is out of linked list,
             * first item is to be deleted
             */
            if (fast == null) {
                head = head.next;
                return head;
            }
        }
        /* move slow and fast pointer one step ahead
         * till fast pointer reaches end, slow points
         * to previous node of nth node from last
         */
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // point next of slow pointer to next of next node
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // int n = 2;

        // ListNode node1 = new ListNode(1);
        // int n = 1;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        int n = 1;

        ListNode head = node1;
        head = removeNthFromEnd(head, n);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
}
