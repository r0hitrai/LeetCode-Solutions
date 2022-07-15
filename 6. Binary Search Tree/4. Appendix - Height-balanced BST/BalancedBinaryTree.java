/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
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

public class BalancedBinaryTree {
    // whether tree is balanced on not
    static boolean isBalance;

    // initialize  isBalance to true
    BalancedBinaryTree() {
        isBalance = true;
    }

    public static boolean isBalanced(TreeNode root) {
        // call isHeightBalanced for root and starting height
        // as 0
        isHeightBalanced(root, 0, 0);
        // return status of balance
        return isBalance;
    }

    /* returns if height of tree and update isBalance */
    static int isHeightBalanced(TreeNode root, int leftHeight, int rightHeight) {
        /* if root is null, height is 0 */
        if (root == null)
            return 0;
        /* go to left subtree with incremented height */
        int left = isHeightBalanced(root.left, leftHeight + 1, rightHeight);
        /* go to right subtree with incremented height */
        int right = isHeightBalanced(root.right, leftHeight, rightHeight + 1);
        /* if height difference of subtrees is more than 1, 
         * then balanced
        */
        if (Math.abs(left - right) > 1)
            isBalance = false;
        // height of current node is 1 more than maximum of
        // subtrees height
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        // TreeNode node5 = new TreeNode(7);
        // TreeNode node4 = new TreeNode(15);
        // TreeNode node3 = new TreeNode(20, node4, node5);
        // TreeNode node2 = new TreeNode(9);
        // TreeNode node1 = new TreeNode(3, node2, node3);

        // TreeNode node7 = new TreeNode(4);
        // TreeNode node6 = new TreeNode(4);
        // TreeNode node5 = new TreeNode(3);
        // TreeNode node4 = new TreeNode(3, node6, node7);
        // TreeNode node3 = new TreeNode(2);
        // TreeNode node2 = new TreeNode(2, node4, node5);
        // TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode node1 = null;

        TreeNode root = node1;
        System.out.println(isBalanced(root));
    }
}