/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; };
}

public class LowestCommonAncestorOfBinaryTree {
    // lowest common ancestor
    static TreeNode ans;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // initialize ans
        ans = null;
        // calling DFS for root, p and q
        DFS(root, p, q);
        return ans;
    }
    /* finding p and q in depth first search */
    static boolean DFS(TreeNode root, TreeNode p, TreeNode q) {
        /* if root is null, return false */
        if (root == null)
            return false;
        // is target in left subtree?
        int isLeft = DFS(root.left, p, q) ? 1 : 0;
        // is target in righ subtree?
        int isRight = DFS(root.right, p, q) ? 1 : 0;
        // is current node is target nodes?
        int isTarget = (root == p || root == q) ? 1 : 0;
        /* if any two  is true, LCA found */
        if (isLeft + isRight + isTarget > 1)
            ans = root;
        // if any one is true, return true
        return isLeft + isRight + isTarget > 0;
    }
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node6 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2, node8, node9);
        TreeNode node4 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1, node6, node7);
        TreeNode node2 = new TreeNode(5, node4, node5);
        TreeNode node1 = new TreeNode(3, node2, node3);

        TreeNode root = node1;
        System.out.println(lowestCommonAncestor(root, node2, node3).val);
    }
}
