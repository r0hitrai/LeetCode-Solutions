/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        // calling DFS() for root
        return DFS(root);
    }
    /* recursively calculating max depth using DFS */
    static int DFS(TreeNode root) {
        /* if root is empty, depth is 0 */
        if (root == null)
            return 0;
        // left subtree depth
        int left = DFS(root.left);
        // right subtree height
        int right = DFS(root.right);
        // return maximum of left and right
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        // TreeNode node2 = new TreeNode(9);
        // TreeNode node4 = new TreeNode(15);
        // TreeNode node5 = new TreeNode(7);
        // TreeNode node3 = new TreeNode(20, node4, node5);
        // TreeNode node1 = new TreeNode(3, node2, node3);

        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, null, node2);

        TreeNode root = node1;
        System.out.println(maxDepth(root));
    }
}