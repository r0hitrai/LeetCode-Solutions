/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
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

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        // return root node created from nums from start
        // to end
        return insertRoot(nums, 0, nums.length - 1);
    }
    /* recursively insert middle num as root node */
    static TreeNode insertRoot(int[] nums, int left, int right) {
        /* if no num in range, return null */
        if (left > right)
            return null;
        // middle index
        int mid = left + (right - left) / 2;
        // make left subtree
        TreeNode leftNode = insertRoot(nums, left, mid - 1);
        // make right subtree
        TreeNode rightNode = insertRoot(nums, mid + 1, right);
        // make root node with left and righ node, return it
        return new TreeNode(nums[mid], leftNode, rightNode);
    }
    public static void main(String[] args) {
        // int[] nums = {-10,-3,0,5,9};
        int[] nums = {1};

        TreeNode root = sortedArrayToBST(nums);
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
    }
}
