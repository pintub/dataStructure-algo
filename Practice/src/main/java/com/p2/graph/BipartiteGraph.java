package com.p2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * For UnDirected Graph
 */
public class BipartiteGraph {

    //Iteration
    public boolean isBipartiteGraph_UsingBfs(int nodeCount, ArrayList<ArrayList<Integer>> adjList) {
        Map<Integer, Integer> nodeVsColorMap = new HashMap<>();
        for(int count = 0; count < nodeCount; count++){
            if(nodeVsColorMap.containsKey(count)) {
                continue;
            }

            if(helperIsBipartiteGraph_UsingBfs(count, adjList, nodeVsColorMap))
                return true;
        }

        return false;
    }

    private boolean helperIsBipartiteGraph_UsingBfs(int node, ArrayList<ArrayList<Integer>> adjList, Map<Integer, Integer> nodeVsColorMap) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        nodeVsColorMap.put(node, 0);//Colors are 0 or 1

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            ArrayList<Integer> neighbors = adjList.get(currentNode);
            for(int neighbor: neighbors) {
                if(nodeVsColorMap.containsKey(neighbor) && Objects.equals(nodeVsColorMap.get(neighbor), nodeVsColorMap.get(neighbor))) {
                    return true;
                } else if(nodeVsColorMap.containsKey(neighbor)) {
                    continue;
                } else {
                    queue.add(neighbor);
                    nodeVsColorMap.put(neighbor, 1 - nodeVsColorMap.get(currentNode));
                }
            }
        }

        return false;
    }

    //Recursion
    public boolean isBipartiteGraph_UsingDfs(int nodeCount, ArrayList<ArrayList<Integer>> adjList) {
        Map<Integer, Integer> nodeVsColorMap = new HashMap<>();
        for(int node = 0; node < nodeCount; node++){
            if(nodeVsColorMap.containsKey(node)) {
                continue;
            }

            if(helperIsBipartiteGraph_UsingDfs(node, adjList, nodeVsColorMap, 1))
                return true;
        }

        return false;
    }

    private boolean helperIsBipartiteGraph_UsingDfs(int node, final ArrayList<ArrayList<Integer>> adjList, Map<Integer, Integer> nodeVsColorMap, int parentColor) {
        if(nodeVsColorMap.containsKey(node) && nodeVsColorMap.get(node)  == parentColor) {
            return true;
        }

        if(nodeVsColorMap.containsKey(node))
            return false;

        nodeVsColorMap.put(node, 1 - parentColor);

        for(int neighbor : adjList.get(node)) {
            if(helperIsBipartiteGraph_UsingDfs(neighbor, adjList, nodeVsColorMap, 1 - parentColor))
                return true;
        }

        return false;
    }
}
