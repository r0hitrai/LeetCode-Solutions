/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/
import java.util.Queue;
import java.util.LinkedList;

/* Definition for a Node. */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointersInEachNode2 {
    public static Node connect(Node root) {
        /* if tree is empty, return itself */
        if (root == null)
            return root;
        // queue for storing neighbuors
        Queue<Node> queue = new LinkedList<>();
        // add root to the queue
        queue.offer(root);
        // while queue if not empty
        while (!queue.isEmpty()) {
            // number of neighbours
            int size = queue.size();
            // for each neighbour
            for (int i = 0; i < size; i++) {
                // current node
                Node node = queue.poll();
                /* current node's next point to next
                 * neighbour, except last node
                 */
                if (i < size - 1)
                    node.next = queue.peek();
                /* if not leaf node, add their child in queue */
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3, null, node7, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node1 = new Node(1, node2, node3, null);

        // Node node1 = null;

        Node root = node1;
        root = connect(root);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(node.val+"("+(node.next == null ? null : node.next.val)+"), ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println();
        }
    }
}
