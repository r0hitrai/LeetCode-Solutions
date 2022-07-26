/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
*/
import java.util.List;
import java.util.ArrayList;

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

public class NAryTreePreorderTraversal {
    public static List<Integer> preorder(Node root) {
        // order of nodes in preorder (Root, Children from left to right)
        List<Integer> order = new ArrayList<>();
        /* if root is not null, then find order */
        if (root != null)
            rootFirst(root, order);
        return order;
    }
    /* add root in order, then children */
    static void rootFirst(Node root, List<Integer> order) {
        // add root's value
        order.add(root.val);
        /* if children exists, then call rootFirst for each children */
        if (root.children != null)
            for (Node child : root.children)
                rootFirst(child, order);
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
        System.out.println(preorder(node1));
    }
}