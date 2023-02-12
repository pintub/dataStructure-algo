package year2k21.common.pattern.graph.date11022023;

import year2k21.common.pattern.graph.date16082022.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph133 {

    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeVsClonedNode = new HashMap();
        if(node == null)
            return null;
        return cloneGraph(node, nodeVsClonedNode )     ;
    }

    private Node cloneGraph(Node node, final Map<Node, Node> nodeVsClonedNode) {
        if(nodeVsClonedNode.containsKey(node)) {//Visited
            return nodeVsClonedNode.get(node);
        }

        Node clonedNode = new Node(node.val);
        nodeVsClonedNode.put(node, clonedNode);

        for(Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor, nodeVsClonedNode));
        }

        return clonedNode;
    }
}