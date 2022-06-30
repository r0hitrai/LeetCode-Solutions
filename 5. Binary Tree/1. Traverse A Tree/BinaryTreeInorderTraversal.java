/*
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
/* Definition for a binary tree node. */
import java.util.List;
import java.util.ArrayList;

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        // list of nodes in inorder (Left, Root, Right)
        List<Integer> inorder = new ArrayList<>();
        /* if tree is empty, return empty list */
        if (root == null)
            return inorder;
        /* calling traverse() for root and inorder */
        traverse(root, inorder);
        return inorder;
    }
    /* recursive function to traverse tree */
    static void traverse(TreeNode root, List<Integer> inorder) {
        /* if left subtree exist, call traverse() for its
         * root
         */
        if (root.left != null)
            traverse(root.left, inorder);
        // add root value in inorder
        inorder.add(root.val);
        /* if right subtree exist, call traverse() for its
         * root
         */
        if (root.right != null)
            traverse(root.right, inorder);
    }
    public static void main(String[] args) {
        // TreeNode node3 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(2, node3, null);
        // TreeNode node1 = new TreeNode(1, null, node2);

        // TreeNode node1 = null;

        TreeNode node1 = new TreeNode(1);

        TreeNode root = node1;
        System.out.println(inorderTraversal(root));
    }
}
