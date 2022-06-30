/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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

public class ConstructBinaryTreeFromInorderAndPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // root node is in the back of postorder, then right 
        // subtree root, then left subtree root and so on.
        // inorder contains left subtree and right subtree at 
        // left and right part of root
        return buildNode(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    /* building node based on range in inorder and index on
     * postorder
     */
    static TreeNode buildNode(int[] inorder, int[] postorder, int leftIndex, int rightIndex, int index) {
        /* if 1 item in inorder range, create node with value
         * of index item in postorder, this node has no children,
         * return this node
         */
        if (leftIndex == rightIndex)
            return new TreeNode(postorder[index]);
        // create root node with value of index item of 
        // postorder
        TreeNode root = new TreeNode(postorder[index]);
        /* find index of root node's value in inorder */
        int rootIndex = leftIndex;
        while (inorder[rootIndex] != postorder[index])
            rootIndex++;
        /* if no item in right subtree, right child is empty */
        if (rootIndex == rightIndex)
            root.right = null;
        /* else create right subtree, its root will be on 
        next node from back of postorder current index */
        else
            root.right = buildNode(inorder, postorder, rootIndex + 1, rightIndex, index - 1);
        /* if no item in left subtree, left child is empty */
        if (rootIndex == leftIndex)
            root.left = null;
        /* else create left subtree, its root will be on 
        number of nodes in right subtree position ahead from 
        back of postorder current index */
        else
            root.left = buildNode(inorder, postorder, leftIndex, rootIndex - 1, index - (rightIndex - rootIndex + 1));
        // return created root node
        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        // int[] inorder = {2,1};
        // int[] postorder = {2,1};

        TreeNode root = buildTree(inorder, postorder);
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