/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* length of both lists */
        int length1 = 0;
        int length2 = 0;
        /* node for traversal */
        ListNode trav1 = l1;
        ListNode trav2 = l2;
        /* length of list1 */
        while (trav1 != null) {
            length1++;
            trav1 = trav1.next;
        }
        /* length of list2 */
        while (trav2 != null) {
            length2++;
            trav2 = trav2.next;
        }
        // if list1 is bigger
        if (length1 > length2) {
            /* start from head */
            trav1 = l1;
            trav2 = l2;
            // power generated from sum
            int power = 0;
            // till end of list2
            while (trav2 != null) {
                // sum of both nodes
                int sum = trav1.val + trav2.val + power;
                // if sum is more than 9
                if (sum > 9) {
                    // power is generated
                    power = 1;
                    // store first digit of sum
                    trav1.val = sum % 10;
                // if sum is less than 10
                } else {
                    // power is not generated
                    power = 0;
                    // store sum
                    trav1.val = sum;
                }
                /* move to next node */
                trav1 = trav1.next;
                trav2 = trav2.next;
            }
            // last node
            ListNode lastNode = new ListNode();
            // for remaining nodes in list1
            while (trav1 != null) {
                // sum of node and power
                int sum = trav1.val + power;
                // if sum is more than 9
                if (sum > 9) {
                    // power is generated
                    power = 1;
                    // store 0 in node
                    trav1.val = 0;
                // if sum is less than 10
                } else {
                    // power is not generated
                    power = 0;
                    // store sum in node
                    trav1.val = sum;
                }
                // store current node
                lastNode = trav1;
                // move to next node
                trav1 = trav1.next;
            }
            // if power remains beyond last node
            if (power == 1) {
                // new node with value 1
                ListNode newNode = new ListNode(1, null);
                // last node next point to newNode
                lastNode.next = newNode;
            }
            return l1;
        // if list2 is equal or bigger
        } else {
            /* start from head */
            trav1 = l1;
            trav2 = l2;
            // last node
            ListNode lastNode = new ListNode();
            // power generated from sum
            int power = 0;
            // till end of list2
            while (trav1 != null) {
                // sum of both nodes
                int sum = trav1.val + trav2.val + power;
                // if sum is more than 9
                if (sum > 9) {
                    // power is generated
                    power = 1;
                    // store first digit of sum
                    trav2.val = sum % 10;
                // if sum is less than 10
                } else {
                    // power is not generated
                    power = 0;
                    // store sum
                    trav2.val = sum;
                }
                // store current node
                lastNode = trav2;
                /* move to next node */
                trav1 = trav1.next;
                trav2 = trav2.next;
            }
            // for remaining nodes in list1
            while (trav2 != null) {
                // sum of node and power
                int sum = trav2.val + power;
                // if sum is more than 9
                if (sum > 9) {
                    // power is generated
                    power = 1;
                    // store 0 in node
                    trav2.val = 0;
                // if sum is less than 10
                } else {
                    // power is not generated
                    power = 0;
                    // store sum in node
                    trav2.val = sum;
                }
                // store current node
                lastNode = trav2;
                // move to next node
                trav2 = trav2.next;
            }
            // if power remains beyond last node
            if (power == 1) {
                // new node with value 1
                ListNode newNode = new ListNode(1, null);
                // last node next point to newNode
                lastNode.next = newNode;
            }
            return l2;
        }
    }
    public static void main(String[] args) {
        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(2, a2);
        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        // ListNode a1 = new ListNode();
        // ListNode b1 = new ListNode();

        // ListNode a7 = new ListNode(9);
        // ListNode a6 = new ListNode(9, a7);
        // ListNode a5 = new ListNode(9, a6);
        // ListNode a4 = new ListNode(9, a5);
        // ListNode a3 = new ListNode(9, a4);
        // ListNode a2 = new ListNode(9, a3);
        // ListNode a1 = new ListNode(9, a2);
        // ListNode b4 = new ListNode(9);
        // ListNode b3 = new ListNode(9, b4);
        // ListNode b2 = new ListNode(9, b3);
        // ListNode b1 = new ListNode(9, b2);

        // ListNode a1 = new ListNode(5);
        // ListNode b1 = new ListNode(5);

        ListNode l1 = a1;
        ListNode l2 = b1;
        ListNode head = addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
