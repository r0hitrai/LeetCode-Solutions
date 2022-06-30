/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
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

public class PathSum {
    // is path sum is equal to target sum?
    static boolean isTargetSum;
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // initialize isTargetSum to false
        isTargetSum = false;
        /* if tree is empty, no path */
        if (root == null)
            return isTargetSum;
        // calling eachPathSum() to check path sum from root
        eachPathSum(root, 0, targetSum);
        return isTargetSum;
    }
    /* recursively checking sum of each path with targetSum */
    static void eachPathSum(TreeNode root, int pathSum, int targetSum) {
        // add root value to pathSum
        pathSum += root.val;
        /* if root is leaf node and targetSum reached, set 
         * isTargetSum to true and return
         */
        if (root.left == null && root.right == null) {
            if (pathSum == targetSum) 
                isTargetSum = true;
            return;
        }
        /* if left child exist, call eachPathSum() for it */
        if (root.left != null)
            eachPathSum(root.left, pathSum, targetSum);
        /* if right child exist, call eachPathSum() for it */
        if (root.right != null)
            eachPathSum(root.right, pathSum, targetSum);
    }
    public static void main(String[] args) {
        // TreeNode node9 = new TreeNode(1);
        // TreeNode node8 = new TreeNode(2);
        // TreeNode node7 = new TreeNode(7);
        // TreeNode node6 = new TreeNode(4, null, node9);
        // TreeNode node5 = new TreeNode(13);
        // TreeNode node4 = new TreeNode(11, node7, node8);
        // TreeNode node3 = new TreeNode(8, node5, node6);
        // TreeNode node2 = new TreeNode(4, node4, null);
        // TreeNode node1 = new TreeNode(5, node2, node3);
        // int targetSum = 22;

        // TreeNode node2 = new TreeNode(2);
        // TreeNode node3 = new TreeNode(3);
        // TreeNode node1 = new TreeNode(1, node2, node3);
        // int targetSum = 5;

        TreeNode node1 = null;
        int targetSum = 0;

        TreeNode root = node1;
        System.out.println(hasPathSum(root, targetSum));
    }
}
