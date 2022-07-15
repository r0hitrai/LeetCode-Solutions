/*
Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ContainsDuplicate3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /* if k is 0 or 1 item in nums, then i and j can't be
         * distinct, hence, false
         */
        if (k == 0 || nums.length == 1)
            return false;
        // start and end index to stay in range of k
        int start = 0, end = 1;
        // root node for BST
        TreeNode root = new TreeNode(nums[start]);
        /* while range is not reached, insert node */
        while (end < nums.length && end <= k) {
            /* if difference below target, return true */
            if (insertAtLeaf(root, nums[end], t))
                return true;
            end++;
        }
        // till end of array
        while (end < nums.length) {
            // delete start node
            root = deleteNode(root, nums[start]);
            /* insert new node, if difference below target, 
             * return ture
             */
            if (insertAtLeaf(root, nums[end], t))
                return true;
            /* move to next items */
            start++;
            end++;
        }
        return false;
    }
    /* go to leaf and insert the node */
    static boolean insertAtLeaf(TreeNode root, int val, int t) {
        /* convert val and root's val to long */
        long a = val;
        long b = root.val;
        /* if absolute difference is less than or equal to
         * target, retun true
         */
        if (Math.abs(a - b) <= t)
            return true;
        // status of left and right subtree
        boolean isLeft = false, isRight = false;
        // if val is less than root's val
        if (val < root.val) {
            /* if left child exist, go to left subtree */
            if (root.left != null)
                isLeft = insertAtLeaf(root.left, val, t);
            /* if left child doesn't exist, create new node
             * and insert at left
             */
            else
                root.left = new TreeNode(val);
        // if val is more than root's val
        } else if (val > root.val) {
            /* if right child exist, go to right subtree */
            if (root.right != null)
                isRight = insertAtLeaf(root.right, val, t);
            /* if right child doesn't exist, create now node
             * and insert at right
             */
            else
                root.right = new TreeNode(val);
        }
        return isRight || isLeft;
    }
    /* delete node */
    static TreeNode deleteNode(TreeNode root, int key) {
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
            root.left = deleteNode(root.left ,key);
        /* if key is more than root's val, go to right
         * subtree
         */
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
    public static void main(String[] args) {
        // int[] nums = {1,2,3,1};
        // int k = 3;
        // int t = 0;
        // int[] nums = {1,0,1,1};
        // int k = 1;
        // int t = 2;
        // int[] nums = {1,5,9,1,5,9};
        // int k = 2;
        // int t = 3;
        int[] nums = {-2147483648,2147483647};
        int k = 1;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
