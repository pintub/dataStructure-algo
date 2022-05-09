package year2k21.common.pattern.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * BFS done w/o graph traversal template way , os ugly code
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution133 {

    Map<Node, Node> originalVsCloneNodeMap = new HashMap<>();

    public Node cloneGraph_DFS_Recursive(Node node) {
        if (node == null) return null;

        if (originalVsCloneNodeMap.containsKey(node)) {
            return originalVsCloneNodeMap.get(node);
        }

        originalVsCloneNodeMap.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors) {
            originalVsCloneNodeMap.get(node).neighbors.add(cloneGraph_DFS_Recursive(neighbor));
        }
        return originalVsCloneNodeMap.get(node);
    }

    public Node cloneGraph_DFS_Iterative(Node node) {
        if (node == null) return null;

        Stack<Node> stack = new Stack<>();//Keeps original Nodes
        stack.add(node);
        Node clonedStartNode = new Node(node.val);
        originalVsCloneNodeMap.put(node, clonedStartNode);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            Node clonedCurrentNode = originalVsCloneNodeMap.get(currentNode);
            for (Node neighbor : currentNode.neighbors) {
                if(originalVsCloneNodeMap.get(neighbor) == null) {//Not visited
                    Node neighborClone = new Node(neighbor.val);
                    originalVsCloneNodeMap.put(neighbor, neighborClone);
                    clonedCurrentNode.neighbors.add(neighborClone);
                    //neighborClone.neighbors.add(clonedCurrentNode);
                    stack.add(neighbor);
                } else {//visited
                    Node neighborClone = originalVsCloneNodeMap.get(neighbor);
                    //clonedCurrentNode.neighbors.add(neighborClone);
                    clonedCurrentNode.neighbors.add(neighborClone);
                }
            }
        }

        return clonedStartNode;
    }

    /**
     * BFS using Queue
     */
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();//For original nodes
        Node[] visited = new Node[101];//101 limit of nodes for original nodes
        Node[] cached = new Node[101];//101 limit of nodes for cloned nodes
        queue.add(node);
        Node clonedStartNode = new Node(node.val);
        cached[node.val] = clonedStartNode;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); //Remove from que and mark as visited and cache cloned node
            visited[currentNode.val] = currentNode;
            Node clonedCurrentNode = (cached[currentNode.val] != null) ? cached[currentNode.val] : new Node(currentNode.val);
            cached[currentNode.val] = clonedCurrentNode;
            for(Node currentNodeNeighbor : currentNode.neighbors) {
                if(visited[currentNodeNeighbor.val] != null) {//Already visited
                    //Do Nothing
                } else if(cached[currentNodeNeighbor.val] != null) {//Cached or Met earlier
                    Node clonedCurrentNodeNeighbor = cached[currentNodeNeighbor.val];
                    clonedCurrentNode.neighbors.add(clonedCurrentNodeNeighbor);
                    clonedCurrentNodeNeighbor.neighbors.add(clonedCurrentNode);
                    queue.add(currentNodeNeighbor);
                } else { //Not cached
                    Node clonedCurrentNodeNeighbor = new Node(currentNodeNeighbor.val);
                    clonedCurrentNode.neighbors.add(clonedCurrentNodeNeighbor);
                    clonedCurrentNodeNeighbor.neighbors.add(clonedCurrentNode);
                    queue.add(currentNodeNeighbor);
                    cached[currentNodeNeighbor.val] = clonedCurrentNodeNeighbor;
                }
            }
        }

        return clonedStartNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clone = new Solution133().cloneGraph_DFS_Iterative(node1);
        System.out.println(clone);
    }

}
