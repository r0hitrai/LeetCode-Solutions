
/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NAryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        // order of nodes in levelorder (Children from top to bottom and left to right)
        List<List<Integer>> order = new ArrayList<>();
        // queue to store children of each level
        Queue<Node> queue = new LinkedList<>();
        /* if root is not null, add in queue */
        if (root != null)
            queue.offer(root);
        // while queue is not empty
        while (!queue.isEmpty()) {
            // list of children's value
            List<Integer> childrenValue = new ArrayList<>();
            // number of children
            int size = queue.size();
            // for each children
            for (int i = 0; i < size; i++) {
                // get first node
                Node cur = queue.poll();
                /* if chlidren exist, add them in queue */
                if (cur.children != null)
                    for (Node child : cur.children)
                        queue.offer(child);
                // add node in children's value list
                childrenValue.add(cur.val);
            }
            // add list of children's value in order list
            order.add(childrenValue);
        }
        return order;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        children1.add(node4);
        node1.children = children1;
        List<Node> children2 = new ArrayList<>();
        children2.add(node5);
        children2.add(node6);
        node2.children = children2;
        System.out.println(levelOrder(node1));
    }
}