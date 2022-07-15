/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

    - BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
    - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    - int next() Moves the pointer to the right, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*/
import java.util.Stack;

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

public class BinarySearchTreeIterator {
    // stack for inorder traversal
    Stack<TreeNode> stack;
    /* Initializes an object of the BSTIterator class. The 
    root of the BST is given as part of the constructor. The 
    pointer should be initialized to a non-existent number 
    smaller than any element in the BST. */
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        inorderTraverse(root);
    }
    /* recursive traversal of tree in inorder and add root
     * and left in stack
    */
    void inorderTraverse(TreeNode root) {
        /* if root is empty, return */
        if (root == null)
            return;
        // add root in stack
        stack.push(root);
        // go to left node
        inorderTraverse(root.left);
    }
    /* Moves the pointer to the right, then returns the 
    number at the pointer. */
    public int next() {
        // get current node from stack
        TreeNode cur = stack.pop();
        // go to inorder of right subtree of current node
        inorderTraverse(cur.right);
        // return current node's value
        return cur.val;
    }
    /* Returns true if there exists a number in the traversal 
    to the right of the pointer, otherwise returns false. */
    public boolean hasNext() {
        // if stack is empty, no next node
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(20);
        TreeNode node4 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15, node4, node5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node1 = new TreeNode(7, node2, node3);
        BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator(node1);
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());

        // TreeNode node1 = new TreeNode(20);
        // BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator(node1);
        // System.out.println(bSTIterator.hasNext());
        // System.out.println(bSTIterator.next());
        // System.out.println(bSTIterator.hasNext());
    }
}