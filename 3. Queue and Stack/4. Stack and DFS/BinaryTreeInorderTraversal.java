/*
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
/* Definition for a binary tree node. */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        // inorder traversal
        List<Integer> result = new ArrayList<>();
        /* if tree is empty, return empty list */
        if (root == null)
            return result;
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        // start with root
        stack.push(root);
        // while stack is not empty
        while (!stack.isEmpty()) {
            // select top node from stack
            TreeNode curNode = stack.peek();
            /* if there is no left node, pop it */
            if (curNode.left == null) {
                visited.add(curNode);
                result.add(stack.pop().val);
                /* if right node exists, push to stack */
                if (curNode.right != null)
                    stack.push(curNode.right);
            /* if left node exists, push to stack */
            } else {
                /* push only if not visited */
                if (visited.add(curNode))
                    stack.push(curNode.left);
                /* if visited, pop itself and if right
                 * node exists, push to stack
                 */
                else {
                    curNode = stack.pop();
                    result.add(curNode.val);
                    if (curNode.right != null)
                        stack.push(curNode.right);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // TreeNode right1 = new TreeNode(2);
        // TreeNode left2 = new TreeNode(3);
        // root.left = null;
        // root.right = right1;
        // right1.left = left2;
        // right1.right = null;
        // left2.left = null;
        // left2.right = null;

        // TreeNode root = new TreeNode(1);
        // TreeNode root2 = new TreeNode(2);
        // TreeNode root3 = new TreeNode(3);
        // TreeNode root4 = new TreeNode(4);
        // TreeNode root5 = new TreeNode(5);
        // TreeNode root6 = new TreeNode(6);
        // TreeNode root7 = new TreeNode(7);
        // root.left = root2;
        // root.right = root3;
        // root2.left = root4;
        // root2.right = root5;
        // root3.left = root6;
        // root3.right = root7;
        // root4.left = null;
        // root4.right = null;
        // root5.left = null;
        // root5.right = null;
        // root6.left = null;
        // root6.right = null;
        // root7.left = null;
        // root7.right = null;

        TreeNode root = new TreeNode(1);
        System.out.println(inorderTraversal(root));
    }
}
