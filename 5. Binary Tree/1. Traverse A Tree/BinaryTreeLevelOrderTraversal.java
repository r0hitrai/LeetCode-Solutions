/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // list of list of nodes at each level
        List<List<Integer>> levelorder = new ArrayList<>();
        /* if empty tree, return empty list */
        if (root == null)
            return levelorder;
        // queue for neighbour nodes
        Queue<TreeNode> queue = new LinkedList<>();
        // add root in queue
        queue.offer(root);
        // while queue is not empty
        while (!queue.isEmpty()) {
            // number of neighbours
            int size = queue.size();
            // list of neighbours
            List<Integer> neighbourNodes = new ArrayList<>();
            // for all neighbours
            for (int i = 0; i < size; i++) {
                // current node
                TreeNode node = queue.poll();
                // add node to neighbourNodes
                neighbourNodes.add(node.val);
                /* if left child exist, add in queue */
                if (node.left != null)
                    queue.offer(node.left);
                /* if right child exist, add in queu */
                if (node.right != null)
                    queue.offer(node.right);
            }
            // add neighbourNodes in levelorder
            levelorder.add(neighbourNodes);
        }
        return  levelorder;
    }
    public static void main(String[] args) {
        // TreeNode node2 = new TreeNode(9);
        // TreeNode node4 = new TreeNode(15);
        // TreeNode node5 = new TreeNode(7);
        // TreeNode node3 = new TreeNode(20, node4, node5);
        // TreeNode node1 = new TreeNode(3, node2, node3);

        // TreeNode node1 = new TreeNode(1);

        TreeNode node1 = null;

        TreeNode root = node1;
        System.out.println(levelOrder(root));
    }
}
