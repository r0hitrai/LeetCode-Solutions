/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.
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

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        /* tree with one node is always BST */
        if (root.left == null && root.right == null)
            return true;
        // calling isValidateNode for root node
        return isValidNode(root, null, null);
    }
    /* recursively validating each node for BST */
    static boolean isValidNode(TreeNode root, Integer lowerBound, Integer upperBound) {
        // if empty node, then valid
        if (root == null)
            return true;
        // is left subtree valid
        boolean isLeft = isValidNode(root.left, lowerBound, root.val);
        // is right subtree valid
        boolean isRight = isValidNode(root.right, root.val, upperBound);
        /* if current node is not in range, tree is not valid */
        if ((lowerBound != null && root.val <= lowerBound) || (upperBound != null && root.val >= upperBound))
            return false;
        // left subtree and right subtree are valid, then 
        // this subtree is valid
        return isLeft && isRight;
    }
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2, node2, node3);

        // TreeNode node5 = new TreeNode(6);
        // TreeNode node4 = new TreeNode(3);
        // TreeNode node3 = new TreeNode(4, node4, node5);
        // TreeNode node2 = new TreeNode(1);
        // TreeNode node1 = new TreeNode(5, node2, node3);

        // TreeNode node1 = new TreeNode(2147483647);

        // TreeNode node2 = new TreeNode(-2147483648);
        // TreeNode node1 = new TreeNode(-2147483648, node2, null);

        // TreeNode node2 = new TreeNode(2147483647);
        // TreeNode node1 = new TreeNode(-2147483648, null, node2);

        // TreeNode node3 = new TreeNode(2);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node1 = new TreeNode(2, node2, node3);

        // TreeNode node5 = new TreeNode(7);
        // TreeNode node4 = new TreeNode(3);
        // TreeNode node3 = new TreeNode(6, node4, node5);
        // TreeNode node2 = new TreeNode(4);
        // TreeNode node1 = new TreeNode(5, node2, node3);

        TreeNode root = node1;
        System.out.println(isValidBST(root));
    }
}