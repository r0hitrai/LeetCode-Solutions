/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

Note that the linked lists must retain their original structure after the function returns.
*/

/* Definition for singly-linked list */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // length of both linked lists
        int lengthA = 1, lengthB = 1;
        // node for listA traversal
        ListNode trav = headA;
        /* calculate length of listA */
        while (trav.next != null) {
            lengthA++;
            trav = trav.next;
        }
        // node for listB traversal
        trav = headB;
        /* calculate length of listB */
        while (trav.next != null) {
            lengthB++;
            trav = trav.next;
        }
        if (lengthA == lengthB) {
            // node to traverse linked lists
            ListNode nodeA = headA, nodeB = headB;
            /* while nodeA is not equal to nodeB */
            while (nodeA != nodeB) {
                // move nodeA one step ahead
                nodeA = nodeA.next;
                // move nodeB one step ahead
                nodeB = nodeB.next;
            }
            // nodeA is now the intersection node
            return nodeA;
        // if listA is bigger
        } else if (lengthA > lengthB) {
            // difference between lengths
            int diff = lengthA - lengthB;
            // node to traverse linked lists
            ListNode nodeA = headA, nodeB = headB;
            /* move nodeA diff steps ahead */
            for (int i = 0; i < diff; i++)
                nodeA = nodeA.next;
            /* while nodeA is not equal to nodeB, 
             * move them one step ahead
            */
            while (nodeA != nodeB) {
                /* if end is reached, no intersection */
                if (nodeA.next == null)
                    return null;
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            // nodeA is now the intersection node
            return nodeA;
        // if listB is bigger
        } else {
            // difference between lengths
            int diff = lengthB - lengthA;
            // node to traverse linked lists
            ListNode nodeA = headA, nodeB = headB;
            /* move nodeB diff steps ahead */
            for (int i = 0; i < diff; i++)
                nodeB = nodeB.next;
            /* whlie nodeA is not equal to nodeB, 
             * move them one step ahead
            */
            while (nodeA != nodeB) {
                /* if end is reached, no intersection */
                if (nodeA.next == null)
                    return null;
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            // nodeA is now the intersection node
            return nodeA;
        }
    }
    public static void main(String[] args) {
        // ListNode a1 = new ListNode(4);
        // ListNode a2 = new ListNode(1);
        // ListNode b1 = new ListNode(5);
        // ListNode b2 = new ListNode(6);
        // ListNode b3 = new ListNode(1);
        // ListNode c1 = new ListNode(8);
        // ListNode c2 = new ListNode(4);
        // ListNode c3 = new ListNode(5);
        // a1.next = a2;
        // a2.next = c1;
        // b1.next = b2;
        // b2.next = b3;
        // b3.next = c1;
        // c1.next = c2;
        // c2.next = c3;

        // ListNode a1 = new ListNode(1);
        // ListNode a2 = new ListNode(9);
        // ListNode a3 = new ListNode(1);
        // ListNode b1 = new ListNode(3);
        // ListNode c1 = new ListNode(2);
        // ListNode c2 = new ListNode(4);
        // a1.next = a2;
        // a2.next = a3;
        // a3.next = c1;
        // b1.next = c1;
        // c1.next = c2;

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;

        ListNode headA = a1;
        ListNode headB = b1;
        System.out.println(getIntersectionNode(headA, headB));
    }
}
