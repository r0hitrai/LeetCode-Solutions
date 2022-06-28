/* 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        /* if empty linked list, return it */
        if (head == null)
            return head;
        // node to traverse linked list
        ListNode trav = head;
        // till last node
        while (trav.next != null) {
            // store next node in temp
            ListNode temp = trav.next;
            // current node points to temp's next node
            trav.next = temp.next;
            // temp points to head node
            temp.next = head;
            // head points to temp
            head = temp;
        }
        // return head of reversed linked list
        return head;
    }
    public static void main(String[] args) {
        // ListNode node5 = new ListNode(5);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);

        // ListNode node2 = new ListNode(2);
        // ListNode node1 = new ListNode(1, node2);

        ListNode node1 = null;

        ListNode head = node1;
        System.out.println("Original list :");
        ListNode trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();

        head = reverseList(head);

        System.out.println("Reversed list :");
        trav = head;
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();
    }
}