/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* if both list empty, return null */
        if (list1 == null && list2 == null)
            return null;
        /* if list1 is empty, return list2
         * and vice versa
         */
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        /* head of merged list */
        ListNode head = null;
        /* nodes for traversal */
        ListNode trav1 = list1.next;
        ListNode trav2 = list2.next;
        /* first smaller node is head and start from
         * next nodes
         */
        if (list1.val < list2.val) {
            head = list1;
            trav1 = list1.next;
            trav2 = list2;
        } else {
            head = list2;
            trav2 = list2.next;
            trav1 = list1;
        }
        ListNode merge = head;
        // while there are nodes in both lists
        while (trav1 != null && trav2 != null) {
            /* compare both nodes of lists and add
             * smaller node in mergerd list, move
             * to next node
             */
            if (trav1.val < trav2.val) {
                merge.next = trav1;
                trav1 = trav1.next;
            } else {
                merge.next = trav2;
                trav2 = trav2.next;
            }
            merge = merge.next;
        }
        /* add remaining nodes in merged list */
        while (trav1 != null) {
            merge.next = trav1;
            trav1 = trav1.next;
            merge = merge.next;
        }
        while (trav2 != null) {
            merge.next = trav2;
            trav2 = trav2.next;
            merge = merge.next;
        }
        return head;
    }
    public static void main(String[] args) {
        // ListNode a3 = new ListNode(4);
        // ListNode a2 = new ListNode(2, a3);
        // ListNode a1 = new ListNode(1, a2);
        // ListNode b3 = new ListNode(4);
        // ListNode b2 = new ListNode(3, b3);
        // ListNode b1 = new ListNode(1, b2);

        // ListNode a1 = null;
        // ListNode b1 = null;

        ListNode a1 = new ListNode(8);
        ListNode b1 = null;

        ListNode list1 = a1;
        ListNode list2 = b1;

        ListNode head = mergeTwoLists(list1, list2);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
}