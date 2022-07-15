/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) { 
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SearchInBinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        /* if root is null, node found */
        if (root == null)
            return null;
        /* if root's val is equal to val, node found */
        else if (val == root.val)
            return root;
        /* if val is less than root's val, go to left subtree */
        else if (val < root.val)
            return searchBST(root.left, val);
        /* if val is more than root's val, go to right subtree */
        else
            return searchBST(root.right, val);
    }
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(4, node2, node3);
        // int val = 2;
        int val = 5;

        TreeNode root = node1;
        TreeNode result = searchBST(root, val);
        if (result != null)
            System.out.println(result.val);
    }
}
