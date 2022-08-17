package com.p2.graph;

import java.util.*;
import java.util.stream.*;

public class CycleDetectionDirectedGraph {

    //BFS using Q, Kahn's algorithm using topological sorting
    private static boolean isCyclicByBfsKahn(int nodeCount, ArrayList<ArrayList<Integer>> graph) {
        System.out.println("Nodes printed are topologically sorted");
        Queue<Integer> queue = new LinkedList<>();
        int[] nodeVsInDegreeMap = new int[nodeCount];
        int sortedNodeCount = 0;

        //Prepare nodeVsInDegreeMap
        for(int node = 0; node < nodeCount; node++){
            for(int neighbor : graph.get(node)) {
                ++nodeVsInDegreeMap[neighbor];
            }
        }

        queue.addAll(findNodesWithZeroInDegree(nodeVsInDegreeMap));

        while (!queue.isEmpty()) {
            int current = queue.remove();
            ++sortedNodeCount;

            System.out.println("Node:" + current);
            nodeVsInDegreeMap[current] = Integer.MIN_VALUE;//Done and Dusted, so mark InDegree as some invalid number, so that next time not considered

            for(int neighbor : graph.get(current)) {
                --nodeVsInDegreeMap[neighbor];//Constantly updating nodeVsInDegreeMap to reduce InDegree for already processed(i.e. already added to sorted list) parents
                if (nodeVsInDegreeMap[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return (sortedNodeCount != nodeCount) ? true: false;
    }

    private static List<Integer> findNodesWithZeroInDegree(int[] nodeVsInDegreeMap) {
        List<Integer> nodesWithZeroInDegree = new ArrayList<>();

        for(int node = 0; node < nodeVsInDegreeMap.length; node++){
            if(nodeVsInDegreeMap[node] == 0){
                nodesWithZeroInDegree.add(node);
            }
        }

        return nodesWithZeroInDegree;
    }

    //Recursion
    private static boolean isCyclicByDfs(int nodeCount, ArrayList<ArrayList<Integer>> graph) {
        int[] nodeVsVisitedFlagMap = new int[nodeCount];//Initially 0, means not visited
        int[] unidirectionalStructure = new int[nodeCount];
        for(int node = 0; node < nodeCount; node++){
            if(nodeVsVisitedFlagMap[node] == 1) {//Visited
                continue;
            }

            if(isCyclicRecursion(node, graph, nodeVsVisitedFlagMap, unidirectionalStructure)){
                return true;
            }
        }

        return false;
    }

    private static boolean isCyclicRecursion(int node, ArrayList<ArrayList<Integer>> graph, int[] nodeVsVisitedFlagMap, int[] unidirectionalStructure) {

        if(unidirectionalStructure[node] == 1) {//Visited and cycle met
            return true;
        }

        if(nodeVsVisitedFlagMap[node] == 1) {//Visited
            return false;
        }

        nodeVsVisitedFlagMap[node] = 1;
        unidirectionalStructure[node] = 1;

        for(int neighbor : graph.get(node)) {
            if(isCyclicRecursion(neighbor, graph, nodeVsVisitedFlagMap, unidirectionalStructure)){
                return true;
            }
        }

        unidirectionalStructure[node] = 0;
        return false;
    }

    public static void main (String[] args) {

        int nodeCount = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(nodeCount);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0); //Comment these 2 lines for Cycle or UnCycle
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        //System.out.println("Cycle detected:" + isCyclicByDfs(nodeCount , graph));
        System.out.println("Cycle detected:" + isCyclicByBfsKahn(nodeCount , graph));
    }

}
