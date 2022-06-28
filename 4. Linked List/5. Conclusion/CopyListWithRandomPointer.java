/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.
*/
import java.util.ArrayList;

/* Definition for a Node. */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        /* if linked list is empty, return head */
        if (head == null)
            return head;
        // list of new nodes
        ArrayList<Node> newNodes = new ArrayList<>();
        // index of newNodes
        int index = 0;
        // first node of deep copy
        Node firstNode = new Node(head.val);
        // add firstNode in newNodes
        newNodes.add(firstNode);
        // change original node val to index, increment index
        head.val = index++;
        // head of deep copy
        Node newHead = firstNode;
        // node for traversing original list
        Node trav = head.next;
        // previous node in deep copy
        Node prevNode = firstNode;
        // till end of original list
        while (trav != null) {
            // new node
            Node newNode = new Node(trav.val);
            // add newNode in newNodes
            newNodes.add(newNode);
            // change trav.val to index, increment index
            trav.val = index++;
            // prevNode next point to newNode
            prevNode.next = newNode;
            // newNode becomes prevNode
            prevNode = newNode;
            // move to next node
            trav = trav.next;
        }
        // traverse from head of original list
        trav = head;
        // traverse from head of deep copy
        Node newTrav = newHead;
        // till end of original list
        while (trav != null) {
            // if trav's random point to a node
            if (trav.random != null)
                newTrav.random = newNodes.get(trav.random.val);
            /* move to next node */
            trav = trav.next;
            newTrav = newTrav.next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        // Node node1 = new Node(7);
        // Node node2 = new Node(13);
        // Node node3 = new Node(11);
        // Node node4 = new Node(10);
        // Node node5 = new Node(1);
        // node1.next = node2;
        // node2.next = node3;
        // node2.random = node1;
        // node3.next = node4;
        // node3.random = node5;
        // node4.next = node5;
        // node4.random = node3;
        // node5.random = node1;

        // Node node1 = new Node(1);
        // Node node2 = new Node(2);
        // node1.next = node2;
        // node1.random = node2;
        // node2.random = node2;

        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;

        Node head = node1;
        Node trav = head;
        while (trav != null) {
            System.out.print(trav + ", ");
            trav = trav.next;
        }
        System.out.println();
        trav = head;
        while (trav != null) {
            if (trav.random != null)
            System.out.print(trav.val + "(" + trav.random.val + "), ");
            else
            System.out.print(trav.val + "(null), ");
            trav = trav.next;
        }
        System.out.println();
        head = copyRandomList(head);
        trav = head;
        while (trav != null) {
            System.out.print(trav + ", ");
            trav = trav.next;
        }
        System.out.println();
        while (head != null) {
            if (head.random != null)
                System.out.print(head.val + "(" + head.random.val + "), ");
            else
            System.out.print(head.val + "(null), ");
            head = head.next;
        }
    }
}
