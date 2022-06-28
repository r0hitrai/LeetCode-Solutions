/*
You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
*/

/* Definition for a Node. */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class FlattenAMultilevelDoublyLinkedList {
    public static Node flatten(Node head) {
        // call traverse on head node whose 
        // parent is null
        traverse(null, head);
        return head;
    }
    /* traverse linked list */
    static Node traverse(Node parent, Node head) {
        // node for traversal
        Node trav = head;
        // last node in the linked list
        Node lastNode = trav;
        // till end of the linked list
        while (trav != null) {
            // store current node is last node
            lastNode = trav;
            /* if child node exists, call traverse
             * on child node
             */
            if (trav.child != null)
                trav = traverse(trav, trav.child);
            else
                // move to next node
                trav = trav.next;
        }
        /* if lastNode and parent node exists, insert child list
         * in after parent node
         */
        if (lastNode != null && parent != null) {
            // lastNode next point to parent next
            lastNode.next = parent.next;
            // if there is a node after parent
            if (parent.next != null)
                // parent next node prev point to lastNode
                parent.next.prev = lastNode;
            // parent next point to head
            parent.next = head;
            // head prev point to parent
            head.prev = parent;
            // set parent child to null
            parent.child = null;
        }
        return lastNode;
    }
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        Node node11 = new Node();
        Node node12 = new Node();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node7.val = 7;
        node8.val = 8;
        node9.val = 9;
        node10.val = 10;
        node11.val = 11;
        node12.val = 12;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = null;
        node11.next = node12;
        node12.next = null;
        node1.prev = null;
        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;
        node7.prev = null;
        node8.prev = node7;
        node9.prev = node8;
        node10.prev = node9;
        node11.prev = null;
        node12.prev = node11;
        node1.child = null;
        node2.child = null;
        node3.child = node7;
        node4.child = null;
        node5.child = null;
        node6.child = null;
        node7.child = null;
        node8.child = node11;
        node9.child = null;
        node10.child = null;
        node11.child = null;
        node12.child = null;

        // Node node1 = new Node();
        // Node node2 = new Node();
        // Node node3 = new Node();
        // node1.val = 1;
        // node2.val = 2;
        // node3.val = 3;
        // node1.next = node2;
        // node2.next = null;
        // node3.next = null;
        // node1.prev = null;
        // node2.prev = node1;
        // node3.prev = null;
        // node1.child = node3;
        // node2.child = null;
        // node3.child = null;

        // Node node1 = null;

        // Node node1 = new Node();
        // Node node2 = new Node();
        // Node node3 = new Node();
        // node1.val = 1;
        // node2.val = 2;
        // node3.val = 3;
        // node1.next = null;
        // node2.next = null;
        // node3.next = null;
        // node1.prev = null;
        // node2.prev = null;
        // node3.prev = null;
        // node1.child = node2;
        // node2.child = node3;
        // node3.child = null;

        Node head = node1;
        head = flatten(head);
        while (head != null) {
            System.out.print(head.val + "(" + head.child + "), ");
            head = head.next;
        }
    }
}
