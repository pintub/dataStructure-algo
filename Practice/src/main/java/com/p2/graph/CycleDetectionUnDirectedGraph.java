package com.p2.graph;

import java.util.*;

/**
 * Here Graph is used as Array list of list instead of Map
 */
public class CycleDetectionUnDirectedGraph {

    //Recursion
    private boolean isCycleByDFS(int nodeCount, ArrayList<ArrayList<Integer>> adjList, int[] nodeVsParentNodeMap) {
        for(int node = 0; node < nodeCount; node++) {//Outer loop
            if (nodeVsParentNodeMap[node] != Integer.MIN_VALUE) {//Visited, so proper parent node maintained
                continue;
            }

            if(isCycle(node, -1, adjList, nodeVsParentNodeMap)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycle(int node, int parentNode, ArrayList<ArrayList<Integer>> adjList, int[] nodeVsParentNodeMap) {
        if(nodeVsParentNodeMap[node] != Integer.MIN_VALUE
                && nodeVsParentNodeMap[node] != parentNode) {
            return true;
        }

        if(nodeVsParentNodeMap[node] != Integer.MIN_VALUE) {
            return false;
        }

        nodeVsParentNodeMap[node] = parentNode;

        for(int neighbor : adjList.get(node)) {
            if(isCycle(neighbor, node, adjList, nodeVsParentNodeMap)){
                return true;
            }
        }

        return false;
    }

    private boolean isCycleByBFS(int nodeCount, ArrayList<ArrayList<Integer>> adjList, int[] nodeVsParentNodeMap) {
        for(int node = 0; node < nodeCount; node++) {//Outer loop
            if(nodeVsParentNodeMap[node] != Integer.MIN_VALUE) {//Visited, so proper parent node maintained
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            nodeVsParentNodeMap[node] = -1;//As it is 1st node of Disconnected component, Maintain Parent as -1

            while (!queue.isEmpty()) {
                int current = queue.remove();

                for(int neighbor : adjList.get(current)) {
                    if(nodeVsParentNodeMap[neighbor] != Integer.MIN_VALUE
                            && nodeVsParentNodeMap[neighbor] != current) {//Visited and visited from different parent => cycle
                        return true;
                    }
                    if(nodeVsParentNodeMap[neighbor] != Integer.MIN_VALUE) {//Visited, but no cycle
                        continue;
                    }
                    nodeVsParentNodeMap[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nodeCount = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adjList.add(i, new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(2).add(3);
        //adjList.get(1).add(3); //Comment or UnComment this for Cycle or UnCycle
        adjList.get(2).add(4);

        //Map<Integer, Integer> nodeVsParentNodeMap = new HashMap<>();
        int[] nodeVsParentNodeMap = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {//Initialize to INT.MIN
            nodeVsParentNodeMap[i] = Integer.MIN_VALUE;
        }

        CycleDetectionUnDirectedGraph obj = new CycleDetectionUnDirectedGraph();
        //System.out.println(obj.isCycleByBFS(nodeCount, adjList, nodeVsParentNodeMap));//nodeCount gives all nodes list, Here [0...4]
        System.out.println(obj.isCycleByDFS(nodeCount, adjList, nodeVsParentNodeMap));
    }
}
