/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
*/
import java.util.Queue;
import java.util.LinkedList;

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

public class InsertInBinarySearchTree {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        /* if root is null, return new node as root */
        if (root == null)
            return new TreeNode(val);
        // insert at leaf and return root
        return insertAtLeaf(root, val);
    }
    /* go to leaf node in BST and insert there */
    static TreeNode insertAtLeaf(TreeNode root, int val) {
        // if val is less than current node's val
        if (val < root.val) {
            /* if left node exist, go to left subtree */
            if (root.left != null)
                insertAtLeaf(root.left, val);
            /* if left node doesn't exist, create new node
             * and insert into left
             */
            else
                root.left = new TreeNode(val);
        }
        // if val is greater than current node's val
        else {
            /* if right node exist, go to right subtree */
            if (root.right != null)
                insertAtLeaf(root.right, val);
            /* if right node doesn't exist, create new node
             * and insert into right
             */
            else
                root.right = new TreeNode(val);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(4, node2, node3);
        int val = 5;
        
        // TreeNode node1 = null;
        // int val = 5;

        TreeNode root = node1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+",");
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        System.out.println();

        root = insertIntoBST(root, val);
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+",");
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        System.out.println();
    }
}
