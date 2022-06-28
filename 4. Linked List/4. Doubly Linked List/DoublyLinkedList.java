/*
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 */
public class DoublyLinkedList {
    /* node having value, next and prev node pointer */
    class Node {
        int val;
        Node next;
        Node prev;
        Node(int x) { val = x; }
    }
    // starting node of linked list
    Node head;
    /* Initializes the DoublyLinkedList object */
    public DoublyLinkedList() {
        head = null;
    }
    /* Get the value of the indexth node in the linked list. If the index is invalid, return -1 */
    public int get(int index) {
        // node for traversal
        Node trav = head;
        /* traverse linked list till index or 
         * end of list
         */
        while (trav != null && index > 0) {
            trav = trav.next;
            index--;
        }
        /* if index not reached, return -1 */
        if (trav == null)
            return -1;
        /* if index reached, return val */
        else
            return trav.val;
    }
    /* Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list */
    public void addAtHead(int val) {
        // new node for val
        Node newNode = new Node(val);
        // newNode next point to head node
        newNode.next = head;
        // newNode prev point to null
        newNode.prev = null;
        /* if head points to a node,
         * point its prev to newNode
         */
        if (head != null)
            head.prev = newNode;
        // head point to newNode
        head = newNode;
    }
    /* Append a node of value val as the last element of the linked list */
    public void addAtTail(int val) {
        // new node for val
        Node newNode = new Node(val);
        // node for traversal
        Node trav = head;
        // if head does not point to a node
        if (trav == null) {
            // head point to newNode
            head = newNode;
            /* newNode next and prev point to null */
            newNode.next = null;
            newNode.prev = null;
        // if head points to a node
        } else {
            /* reach to last node */
            while (trav.next != null)
                trav = trav.next;
            // last node next point to newNode
            trav.next = newNode;
            // newNode prev point to last node
            newNode.prev = trav;
            // newNode next point to null
            newNode.next = null;
        }
    }
    /* Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted */
    public void addAtIndex(int index, int val) {
        /* if index is 0, call addAtHead */
        if (index == 0)
            addAtHead(val);
        // if index is not 0
        else {
            // new node for val
            Node newNode = new Node(val);
            // node for traversal
            Node trav = head;
            /* reach to end of list or index */
            while (trav != null && index > 0) {
                trav = trav.next;
                index--;
            }
            /* if index is equal to length, 
             * add node at the end
             */
            if (trav == null && index == 0)
                addAtTail(val);
            /* if index is reached */
            else if (trav != null) {
                // newNode next point to current node
                newNode.next = trav;
                /* if there is a node before current node,
                 * newNode prev point to it, else point to null
                 * and newNode becomes head
                 */
                if (trav.prev == null) {
                    newNode.prev = null;
                    head = newNode;
                } else {
                    // newNode prev point to previous node
                    newNode.prev = trav.prev;
                    // previous node next point to newNode
                    trav.prev.next = newNode;
                    // current node prev point to newNode;
                    trav.prev = newNode;
                }
            }
        }
    }
    /* Delete the indexth node in the linked list, if the index is valid */
    public void deleteAtIndex(int index) {
        /* if index is 0 and not empty linked list, 
        move head to next node */
        if (index == 0 && head != null)
            head = head.next;
        else {

            // node for traversal
            Node trav = head;
            /* till end of list or index */
            while (trav.next != null && index > 0) {
                trav = trav.next;
                index--;
            }
            /* if index is reached */
            if (index == 0) {
                // if previous node does not exist
                if (trav.prev == null)
                    // head point to next node
                    head = trav.next;
                // if previous node exist
                else {
                    // previous node next point to next
                    trav.prev.next = trav.next;
                    // if next node exits
                    if (trav.next != null)
                        // next node prev point to previous node
                        trav.next.prev = trav.prev;
                }
            }
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList();
        // myLinkedList.addAtHead(1);
        // myLinkedList.addAtTail(3);
        // myLinkedList.addAtIndex(1, 2);
        // System.out.println(myLinkedList.get(1));
        // myLinkedList.deleteAtIndex(1);
        // System.out.println(myLinkedList.get(1));

        // myLinkedList.addAtHead(2);
        // myLinkedList.deleteAtIndex(1);
        // myLinkedList.addAtHead(2);
        // myLinkedList.addAtHead(7);
        // myLinkedList.addAtHead(3);
        // myLinkedList.addAtHead(2);
        // myLinkedList.addAtHead(5);
        // myLinkedList.addAtTail(5);
        // System.out.println(myLinkedList.get(5));
        // myLinkedList.deleteAtIndex(6);
        // myLinkedList.deleteAtIndex(4);

        // myLinkedList.addAtIndex(0, 10);
        // myLinkedList.addAtIndex(0, 20);
        // myLinkedList.addAtIndex(1, 30);
        // System.out.println(myLinkedList.get(0));
        // System.out.println(myLinkedList.get(1));
        // System.out.println(myLinkedList.get(2));
        // System.out.println(myLinkedList.get(3));

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
    }
}