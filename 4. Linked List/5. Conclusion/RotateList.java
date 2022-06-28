/*
Given the head of a linked list, rotate the list to the right by k places.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        /* if k is 0, return head */
        if (k == 0)
            return head;
        // length of linked list
        int length = 0;
        // node for traversal
        ListNode trav = head;
        // calculate length of linked list
        while (trav != null) {
            length++;
            trav = trav.next;
        }
        /* if length is less than two or number of steps to
        move is 0, return head */
        if (length < 2 || k % length == 0)
            return head;
        // number of steps to move
        int step = k % length;
        // last node
        ListNode lastNode = head;
        /* traverse lastNode step number ahead */
        while (step > 0) {
            lastNode = lastNode.next;
            step--;
        }
        // new last node
        ListNode newLastNode = head;
        /* traverse newLastNode till lastNode reaches last
         node */
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            newLastNode = newLastNode.next;
        }
        // lastNode's next point to head
        lastNode.next = head;
        // head point newLastNode's next
        head = newLastNode.next;
        // newLastNode's next point to null
        newLastNode.next = null;
        return head;
    }
    public static void main(String[] args) {
        // ListNode node5 = new ListNode(5);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);
        // int k = 2;

        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(0, node2);
        int k = 4;

        ListNode head = node1;
        head = rotateRight(head, k);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
