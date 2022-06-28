/*
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 */
public class SinglyLinkedList {
    /* Node having value and next node */
    class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
        }
    }
    // start node of the linked list
    Node head;
    /* Initializes the MyLinkedList object  */
    public SinglyLinkedList() {
        // empty list so head points to null
        head = null;
    }
    /* Get the value of the indexth node in the linked list. If the index is invalid, return -1 */
    public int get(int index) {
        // length of linked list
        int length = 0;
        // node for traversal
        Node trav = head;
        // if linked list is not empty
        if (head != null) {
            // starting length is 1
            length = 1;
            /* while next node exists, increase length
            and move to next node
             */
            while (trav.next != null) {
                length++;
                trav = trav.next;
            }
        }
        /* if index is out of linked list, return -1 */
        if (index > length - 1)
            return -1;
        /* if index is in linked list */
        else {
            /* start from head */
            trav = head;
            /* move to the index node */
            for (int i = 1; i <= index; i++)
                trav = trav.next;
            // return its value
            return trav.val;
        }
    }
    /* Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list */
    public void addAtHead(int val) {
        // create node with val
        Node node = new Node(val);
        // point new node next to head
        node.next = head;
        // head becomes new node
        head = node;
    }
    /* Append a node of value val as the last element of the linked list */
    public void addAtTail(int val) {
        /* if linked list is empty, insert at head */
        if (head == null)
            addAtHead(val);
        // if linked list is not empty
        else {
            // create node with val
            Node node = new Node(val);
            // new node next is null
            node.next = null;
            // node for traversal
            Node trav = head;
            /* move to last node */
            while (trav.next != null)
                trav = trav.next;
            /* last node's next node is new node */
            trav.next = node;
        }
    }
    /* Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted */
    public void addAtIndex(int index, int val) {
        /* if index is 0, insert at head */
        if (index == 0)
            addAtHead(val);
        // if index is not 0
        else {
            // length of linked list
            int length = 0;
            // node for traversal
            Node trav = head;
            // if linked list is not empty
            if (head != null) {
                // starting length
                length = 1;
                /* while next node exists, increase length
                and move to next node
                */
                while (trav.next != null) {
                    length++;
                    trav = trav.next;
                }
            }
            /* if index is last item,
             * insert at tail
             */
            if (index == length)
                addAtTail(val);
            // if index is in linked list
            else if (index < length) {
                // create node with val
                Node node = new Node(val);
                // previous node
                Node prev = head;
                /* go to previous node */
                for (int i = 1; i < index; i++)
                    prev = prev.next;
                // next node
                Node next = prev.next;
                // previous node's next node is new node
                prev.next = node;
                // new node's next is next node
                node.next = next;
            }
        }
    }
    /* Delete the indexth node in the linked list, if the index is valid */
    public void deleteAtIndex(int index) {
        // if index is, move head to its next node
        if (index == 0)
            head = head.next;
        // if index is not 0
        else {
            // length of linked list
            int length = 0;
            // node for traversal
            Node trav = head;
            // if linked list is not empty
            if (head != null) {
                // starting length
                length = 1;
                /* while next node exists, increase length
                and move to next node
                */
                while (trav.next != null) {
                    length++;
                    trav = trav.next;
                }
            }
            /* if index is in linked list */
            if (index < length) {
                // previous node
                Node prev = head;
                /* move to previous node */
                for (int i = 1; i < index; i++)
                    prev = prev.next;
                // previous node's next is next of next node
                prev.next = prev.next.next;
            }
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        // myLinkedList.addAtHead(1);
        // myLinkedList.addAtTail(3);
        // myLinkedList.addAtIndex(1, 2);
        // System.out.println(myLinkedList.get(1));
        // myLinkedList.deleteAtIndex(1);
        // System.out.println(myLinkedList.get(1));

        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.get(5));
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
}