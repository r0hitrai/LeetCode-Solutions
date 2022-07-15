/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorOfBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* if p and q are not on same side, then root is LCA */
        if ((p.val <= root.val && q.val >= root.val) || (q.val <= root.val && p.val >= root.val))
            return root;
        // value of LCA
        int valLCA = 0;
        /* if p is less than root, go left */
        if (p.val < root.val)
            valLCA = lowestCommonAncestor(root.left, p, q).val;
        /* if p is more than root, go right */
        else
            valLCA = lowestCommonAncestor(root.right, p, q).val;
        // return node for value of LCA
        return new TreeNode(valLCA);
    }
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(5);
        TreeNode node8 = new TreeNode(3);
        TreeNode node7 = new TreeNode(9);
        TreeNode node6 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);
        TreeNode node4 = new TreeNode(0);
        TreeNode node3 = new TreeNode(8);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        TreeNode root = node1;
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        // TreeNode p = new TreeNode(8);
        // TreeNode q = new TreeNode(2);
        // TreeNode p = new TreeNode(2);
        // TreeNode q = new TreeNode(4);
        // TreeNode p = new TreeNode(4);
        // TreeNode q = new TreeNode(2);
        // TreeNode p = new TreeNode(8);
        // TreeNode q = new TreeNode(7);
        // TreeNode p = new TreeNode(7);
        // TreeNode q = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
