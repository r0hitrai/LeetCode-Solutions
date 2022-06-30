/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
*/
import java.util.Queue;
import java.util.LinkedList;

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // root node is in the front of preorder, then right 
        // subtree root, then left subtree root and so on.
        // inorder contains left subtree and right subtree at 
        // left and right part of root
        return buildNode(preorder, inorder, 0, inorder.length - 1, 0);
    }
    /* building node based on range in inorder and index on
     * preorder
     */
    static TreeNode buildNode(int[] preorder, int[] inorder, int leftIndex, int rightIndex, int index) {
        /* if 1 item in inorder range, create node with value
         * of index item in preorder, this node has no  
         * children, return this node
         */
        if (leftIndex == rightIndex)
            return new TreeNode(preorder[index]);
        // create root node with value of index item of 
        // preorder
        TreeNode root = new TreeNode(preorder[index]);
        /* find index of root node's value in inorder */
        int rootIndex = leftIndex;
        while (inorder[rootIndex] != preorder[index])
            rootIndex++;
        /* if no item in left subtree, left child is empty */
        if (rootIndex == leftIndex)
            root.left = null;
        /* else create left subtree, its root will be on 
        number of nodes in left subtree position ahead from 
        front of preorder current index */
        else
            root.left = buildNode(preorder, inorder, leftIndex, rootIndex - 1, index + 1);
        /* if no item in right subtree, right child is empty */
        if (rootIndex == rightIndex)
            root.right = null;
        /* else create right subtree, its root will be on 
        next node from front of preorder current index */
        else
            root.right = buildNode(preorder, inorder, rootIndex + 1, rightIndex, index + (rootIndex - leftIndex + 1));
        // return created root node
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        // int[] preorder = {1,2,3};
        // int[] inorder = {2,1,3};

        TreeNode root = buildTree(preorder, inorder);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val+", ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println();
        }
    }
}
