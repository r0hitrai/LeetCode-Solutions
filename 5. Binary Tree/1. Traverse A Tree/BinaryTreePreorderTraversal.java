/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/
import java.util.List;
import java.util.ArrayList;

/* Definition for a binray tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        // list of nodes in preorder (Root, Left, Right)
        List<Integer> preorder = new ArrayList<>();
        /* if tree is empty, return empty list */
        if (root == null)
            return preorder;
        // calling traverse() for root node and preorder
        traverse(root, preorder);
        return preorder;
    }
    /* recursive function to traverse tree */
    static void traverse(TreeNode root, List<Integer> preorder) {
        // add Root in preorder
        preorder.add(root.val);
        /* if left subtree exist, call traverse() for its
         * root
         */
        if (root.left != null)
            traverse(root.left, preorder);
        /* if right subtree exist, call traverse() for its
         * root
         */
        if (root.right != null)
            traverse(root.right, preorder);
    }
    public static void main(String[] args) {
        // TreeNode node3 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(2, node3, null);
        // TreeNode node1 = new TreeNode(1, null, node2);

        TreeNode node1 = null;

        // TreeNode node1 = new TreeNode(1);

        TreeNode root = node1;
        List<Integer> preorder = preorderTraversal(root);
        System.out.println(preorder);
    }
    
}