/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
    1. Search for a node to remove.
    2. If the node is found, delete the node.
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

public class DeleteInBinarySearchTree {
    public static TreeNode deleteNode(TreeNode root, int key) {
        /* if root is null or leaf node, key doesn't exist */
        if (root == null)
            return root;
        // if root is the key
        if (root.val == key) {
            /* if root has no child, remove it */
            if (root.left == null && root.right == null)
                root = null;
            /* if root has both child, replace its val with
             * inorder successor's val
             */
            else if (root.left != null && root.right != null) {
                // inorder successor node
                TreeNode successor = root.right;
                /* go to left most node */
                while (successor.left != null)
                    successor = successor.left;
                // successor's val
                int val = successor.val;
                // delete successor node
                deleteNode(root, val);
                // replace root's val by val
                root.val = val;
            /* if root has left child, replace it with left
            * child, else replace it with right child
            */
            } else
                root = root.left != null ? root.left : root.right;
        /* if key is less than root's val, go to left subtree */
        } else if (key < root.val)
           root.left = deleteNode(root.left, key);
        /* if key is more than root's val, go to right 
         * subtree
         */
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6, null, node6);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode node1 = new TreeNode(5, node2, node3);
        int key = 5;
        
        // TreeNode node1 = new TreeNode(0);
        // int key = 0;

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

        root = deleteNode(root, key);

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
