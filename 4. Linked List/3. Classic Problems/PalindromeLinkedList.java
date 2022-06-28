/*
Given the head of a singly linked list, return true if it is a palindrome.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        /* if 1 node, then palindrome */
        if (head.next == null)
            return true;
        // length of linked list
        int length = 0;
        // node for traversal
        ListNode trav = head;
        /* increment length till end of linked list */
        while (trav != null) {
            length++;
            trav = trav.next;
        }
        // middle of linked list
        int mid = length / 2;
        // node for traversal
        trav = head;
        /* reverse first half of linked list */
        for (int i = 0; i < mid - 1; i++) {
            // next node
            ListNode nextNode = trav.next;
            trav.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }
        /* if even length, second half of linked list
         * starts from next of trav
         */
        if (length % 2 == 0)
            trav = trav.next;
        /* if odd length, second half of linked list
         * starts from next of next of trav
         */
        else
            trav = trav.next.next;
        /* compare first and second half of linked list
         * if equals, then palindrome, if not equal,
         * not a palindrome
         */
        ListNode first = head;
        while (trav != null) {
            if (first.val != trav.val)
                return false;
            first = first.next;
            trav = trav.next;
        }
        return true;
    }
    public static void main(String[] args) {
        // ListNode node4 = new ListNode(1);
        // ListNode node3 = new ListNode(2, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);

        // ListNode node2 = new ListNode(2);
        // ListNode node1 = new ListNode(1, node2);

        ListNode node1 = new ListNode(1);

        ListNode head = node1;
        ListNode trav = head;
        System.out.println("original : ");
        while (trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println();
        System.out.println(isPalindrome(head));
    }
}
