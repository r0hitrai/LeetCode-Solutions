/*
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        /* if empty linked list, return it */
        if (head == null)
            return head;
        /* if val is 0, no need to remove */
        if (val == 0)
            return head;
        // node to traverse
        ListNode trav = head;
        // till end of the linked list
        while (trav.next != null) {
            /* if next node is val, then current node
             * points to next node's next node
             */
            if (trav.next.val == val)
                trav.next = trav.next.next;
            /* if next node is not val, move to nest node */
            else
                trav = trav.next;
        }
        /* if first node is val, point head to next node */
        if (head.val == val)
            head = head.next;
        return head;
    }
    public static void main(String[] args) {
        // ListNode node7 = new ListNode(6);
        // ListNode node6 = new ListNode(5, node7);
        // ListNode node5 = new ListNode(4, node6);
        // ListNode node4 = new ListNode(3, node5);
        // ListNode node3 = new ListNode(6, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);
        // int val = 6;

        // int val = 1;

        ListNode node4 = new ListNode(7);
        ListNode node3 = new ListNode(7, node4);
        ListNode node2 = new ListNode(7, node3);
        ListNode node1 = new ListNode(7, node2);
        int val = 7;

        ListNode head = node1;
        System.out.println("original : ");
        ListNode trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();

        head = removeElements(head, val);

        System.out.println("result : ");
        trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();
    }
}