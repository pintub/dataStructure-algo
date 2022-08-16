package year2k21.common.pattern.graph.date16082022;

import java.util.*;

//Traverse and clone
//Using DFS w/ Recursion
public class CloneGraph133 {

    public Node cloneGraphBettered(Node node) {
        Map<Node, Node> nodeVsClonedNodeMap = new HashMap<>();

        return dfsBettered(node, nodeVsClonedNodeMap);
    }


    private Node dfsBettered(Node node, Map<Node, Node> nodeVsClonedNodeMap) {
        if (node == null) return null;

        if (nodeVsClonedNodeMap.containsKey(node)) {
            return nodeVsClonedNodeMap.get(node);
        }

        nodeVsClonedNodeMap.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors) {
            nodeVsClonedNodeMap.get(node).neighbors.add(dfsBettered(neighbor, nodeVsClonedNodeMap));
        }
        return nodeVsClonedNodeMap.get(node);
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeVsClonedNodeMap = new HashMap<>();
        Map<Node, Boolean> nodeVsVisitedMap = new HashMap<>();
        dfs(node, nodeVsClonedNodeMap, nodeVsVisitedMap);

        return nodeVsClonedNodeMap.get(node);
    }

    //Recursion
    //In a call-stack, responsibility is to maintain all outgoing relations from input node
    private void dfs(Node node, Map<Node, Node> nodeVsClonedNodeMap, Map<Node, Boolean> nodeVsVisitedMap) {
        if(node == null) {
            return;
        }

        if(nodeVsVisitedMap.get(node)!= null && nodeVsVisitedMap.get(node)) {//Visited
            return;
        }

        nodeVsVisitedMap.put(node, true);

        Node clonedNode = nodeVsClonedNodeMap.get(node);
        if (clonedNode == null) {
            clonedNode = new Node(node.val);
            nodeVsClonedNodeMap.put(node, clonedNode);//Just a dummy node, neighbor not yet filled
        }

        for(Node neighbor : node.neighbors) {
            Node clonedNeighborNode = nodeVsClonedNodeMap.get(neighbor);
            if(clonedNeighborNode == null){
                clonedNeighborNode = new Node(neighbor.val);
                nodeVsClonedNodeMap.put(neighbor, clonedNeighborNode);
                clonedNode.neighbors.add(clonedNeighborNode);
            } else {
                clonedNode.neighbors.add(clonedNeighborNode);
            }

            dfs(neighbor, nodeVsClonedNodeMap, nodeVsVisitedMap);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);node1.neighbors.add(node3);
        node2.neighbors.add(node1);node2.neighbors.add(node3);
        node3.neighbors.add(node2);node3.neighbors.add(node4);
        node4.neighbors.add(node1);node4.neighbors.add(node3);

        //Node clonedNode1 = new CloneGraph133().cloneGraph(node1);
        Node clonedNode1 = new CloneGraph133().cloneGraphBettered(node1);
        //Node clonedNode1 = new CloneGraph133().cloneGraph(new Node(1));
        //Node clonedNode1 = new CloneGraph133().cloneGraph(null);
        //Debug a see clonedNode1
        System.out.println("---END---");
    }
}
