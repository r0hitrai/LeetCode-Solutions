
/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
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

public class MaxDepthOfNAryTree {
    public static int maxDepth(Node root) {
        /* if root is null, height is 0 */
        if (root == null)
            return 0;
        /* if no children, height is 1 */
        if (root.children == null)
            return 1;
        // maximum height of children
        int maxHeight = 0;
        /*
         * find height of each children and save maximum
         * of that in maxHeight
         */
        for (Node child : root.children) {
            int height = maxDepth(child);
            if (height > maxHeight)
                maxHeight = height;
        }
        // return maxHeight incremented for current node
        return maxHeight + 1;
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
        System.out.println(maxDepth(node1));
    }
}