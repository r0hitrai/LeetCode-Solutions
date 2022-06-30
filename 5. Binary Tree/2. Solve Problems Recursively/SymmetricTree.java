/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*/

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
}

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        // checking symmetry of tree using mirrorTraverse()
        // for left subtree and right subtree
        return mirrorTraverse(root.left, root.right);
    }
    /* recursively traversing in left subtree and mirroring 
     * it in right sub tree
     */
    static boolean mirrorTraverse(TreeNode leftChild, TreeNode rightChild) {
        /* if both subtree is null, tree is symmetric */
        if (leftChild == null && rightChild == null)
            return true;
        /* if only one subtree is null, tree is not symmetric */
        else if (leftChild == null || rightChild == null)
            return false;
        // checking symmetry of left subtree using 
        // mirrorTraverse() for left subtree of leftChild and 
        // right subtree of right child
        boolean isLeftSymmetric = mirrorTraverse(leftChild.left, rightChild.right);
        // checking symmetry of right subtree usig
        // mirrorTraverse() for left subtree of leftChild and
        // right subtree of right child
        boolean isRightSymmetric = mirrorTraverse(leftChild.right, rightChild.left);
        /* if value of leftChild and rightChild is equal and 
         * left subtree and right subtree are symmetric, then 
         * tree is symmetric
         */
        if (leftChild.val == rightChild.val && isLeftSymmetric && isRightSymmetric)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        // TreeNode node4 = new TreeNode(3);
        // TreeNode node5 = new TreeNode(4);
        // TreeNode node6 = new TreeNode(4);
        // TreeNode node7 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(2, node4, node5);
        // TreeNode node3 = new TreeNode(2, node6, node7);
        // TreeNode node1 = new TreeNode(1, node2, node3);

        // TreeNode node4 = new TreeNode(3);
        // TreeNode node5 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(2, null, node4);
        // TreeNode node3 = new TreeNode(2, null, node5);
        // TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode node1 = new TreeNode(1);

        TreeNode root = node1;
        System.out.println(isSymmetric(root));
    }
}
