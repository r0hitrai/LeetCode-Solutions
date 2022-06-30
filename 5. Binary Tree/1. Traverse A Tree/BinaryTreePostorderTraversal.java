/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.
*/
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

public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        // list of nodes in postorder (Left, Right, Root)
        List<Integer> postorder = new ArrayList<>();
        /* if tree is empty, return empty list */
        if (root == null)
            return postorder;
        // calling traverse() for root and postorder
        traverse(root, postorder);
        return postorder;
    }
    /* recursive function for traversing tree */
    static void traverse(TreeNode root, List<Integer> postorder) {
        /* if left subtree exist, call traverse() for its
         * root
         */
        if (root.left != null)
            traverse(root.left, postorder);
        /* if right subtree exist, call traverse() for its
         * root
         */
        if (root.right != null)
            traverse(root.right, postorder);
        // add value of root in postroder
        postorder.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        // TreeNode node1 = null;

        // TreeNode node1 = new TreeNode(1);

        TreeNode root = node1;
        System.out.println(postorderTraversal(root));
    }
}
