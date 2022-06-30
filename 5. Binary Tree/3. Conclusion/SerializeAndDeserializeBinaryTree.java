/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
*/
import java.util.Queue;
import java.util.LinkedList;

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
}

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /* if tree is empty, return empty code */
        if (root == null)
            return null;
        // serialized string
        StringBuilder code = new StringBuilder();
        // queue for storing neighbours
        Queue<TreeNode> queue = new LinkedList<>();
        // start with root
        queue.offer(root);
        // add root value in code
        code.append(root.val+",");
        // while queue is not empty
        while (!queue.isEmpty()) {
            // take current node from queue
            TreeNode node = queue.poll();
            /* if left child exist, add in queue and value in
             * code
            */
            if (node.left != null) {
                queue.offer(node.left);
                code.append(node.left.val+",");
            }
            /* if no left chid, add # in code */
            else
                code.append("#,");
            /* if right child exist, add in queue and value
             * in code
            */
            if (node.right != null) {
                queue.offer(node.right);
                code.append(node.right.val+",");
            }
            /* if no right child, add # in code */
            else
                code.append("#,");
        }
        code.deleteCharAt(code.length() - 1);
        // return code in string format
        return code.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /* if data is empty, return empty tree */
        if (data == null)
            return null;
        // get array of values by splitting data string on ,
        String[] values = data.split(",");
        // root node and data first number is its value
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        // queue for neighbouring nodes
        Queue<TreeNode> queue = new LinkedList<>();
        // start with root
        queue.offer(root);
        // index for accessing value in data, start from root
        int index = 0;
        // while queue is not empty
        while (!queue.isEmpty()) {
            // get current node from queue
            TreeNode cur = queue.poll();
            /* if next value in data is not #, create left 
             * child with that value and add it in queue
             */
            if (!values[++index].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(cur.left);
            }
            /* if next value in data is not #, create right
             * child with that value and add it in queue
             */
            if (!values[++index].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, node3);

        // TreeNode node1 = null;

        TreeNode root = node1;
        SerializeAndDeserializeBinaryTree ser = new SerializeAndDeserializeBinaryTree();
        SerializeAndDeserializeBinaryTree deser = new SerializeAndDeserializeBinaryTree();
        System.out.println(ser.serialize(root));
        root = deser.deserialize((ser.serialize(root)));
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
