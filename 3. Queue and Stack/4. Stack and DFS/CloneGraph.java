/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* Definition for a Node */
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    public static Node cloneGraph(Node node) {
        /* return null if no node */
        if (node == null)
            return null;
        // clone initial node
        Node start = new Node(node.val);
        // to check visited status from index
        Node[] visited = new Node[101];
        // initialize all index with null
        Arrays.fill(visited, null);
        // call DFS
        DFS(node, start, visited);
        // return start node
        return start;
    }
    static void DFS(Node node, Node start, Node[] visited) {
        // set start node as visited
        visited[start.val] = start;
        // for each neighbor
        for (Node nb : node.neighbors) {
            /* if neighbor is not visited,
             * clone it, add into start neighbor,
             * call DFS on it
             */
            if (visited[nb.val] == null) {
                Node newNode = new Node(nb.val);
                start.neighbors.add(newNode);
                DFS(nb, newNode, visited);
            /* if neighbor is already visited,
             * add into start neighbor
             */
            } else {
                start.neighbors.add(visited[nb.val]);
            }
        }
    }
    public static void main(String[] args) {
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        Node[] nodes = new Node[adjList.length];
        for (int i = 0; i < adjList.length; i++)
            nodes[i] = new Node(i + 1);
        int i = 0;
        for (int[] items : adjList) {
            for (int item : items) {
                nodes[i].neighbors.add(nodes[item - 1]);
            }
            i++;
        }
        System.out.println("original:");
        for (Node node : nodes) {
            System.out.println("node: " + node.val);
            System.out.println("neighbors: " + node.neighbors.get(0).val + ", " + node.neighbors.get(1).val);
        }
        System.out.println();
        Node result = cloneGraph(nodes[0]);
        System.out.println("copied:");
        System.out.println("node: " + result.val);
        System.out.println("neighbors: " + result.neighbors.get(0).val + ", " + result.neighbors.get(1).val);
    }
}
