/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        /* if 0 or 1 node, no need to modify, return head */
        if (head == null || head.next == null)
            return head;
        // odd node pointer
        ListNode odd = head;
        // even node pointer
        ListNode even = head.next;
        // till end of the linked list
        while (even != null && even.next != null) {
            // next node to odd pointer
            ListNode oddNext = odd.next;
            // next node to even pointer
            ListNode evenNext = even.next;
            // odd points to even's next node
            odd.next = even.next;
            // even points to even's next to next pointer
            even.next = even.next.next;
            // evenNext points to oddNext
            evenNext.next = oddNext;
            // move odd pointer one step ahead
            odd = odd.next;
            // move even pointer one step ahead
            even = even.next;
        }
        return head;
    }
    public static void main(String[] args) {
        // ListNode node5 = new ListNode(5);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);

        // ListNode node7 = new ListNode(7);
        // ListNode node6 = new ListNode(4, node7);
        // ListNode node5 = new ListNode(6, node6);
        // ListNode node4 = new ListNode(5, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(1, node3);
        // ListNode node1 = new ListNode(2, node2);

        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node1;
        System.out.println("original :");
        ListNode trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();

        head = oddEvenList(head);
        
        System.out.println("result :");
        trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();
    }
}
