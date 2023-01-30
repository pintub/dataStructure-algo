package com.p2.graph;

import java.util.*;

//Only meant for DAGs
public class TopologicalSort {

    //Recursion
    //visited map + (Stack to keep sorted elements)
    public static int[] topologicalSortByDfs(int nodeCount, ArrayList<ArrayList<Integer>> adj) {
        int[] nodeVsVisitedFlagMap = new int[nodeCount];
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nodeCount];

        for(int node=0; node < nodeCount; node++){//Outer loop
            if(nodeVsVisitedFlagMap[node] == 1) {//Visited
                continue;
            }

            topologicalSortByDfsRecursion(node, adj, nodeVsVisitedFlagMap, stack);
        }

        for(int count=0; count < nodeCount; count++) {//Fetch Top to Bottom from Stack
            result[count] = stack.pop();
        }

        return result;
    }

    private static void topologicalSortByDfsRecursion(int node, ArrayList<ArrayList<Integer>> adj, int[] nodeVsVisitedFlagMap, Stack<Integer> stack) {
        if(nodeVsVisitedFlagMap[node] == 1){
            return;
        }

        nodeVsVisitedFlagMap[node] = 1;

        for(int neighbor : adj.get(node)) {
            topologicalSortByDfsRecursion(neighbor, adj, nodeVsVisitedFlagMap, stack);
        }

        stack.push(node);
    }

    /**
     * Refer {@link com.p2.graph.CycleDetectionDirectedGraph#isCyclicByBfsKahn(int, java.util.ArrayList)}
     */
    private static int[] topologicalSortByBfs(int nodeCount, ArrayList<ArrayList<Integer>> adj) {
        return new int[0];
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int nodeCount = 6;
        for (int i = 0; i < nodeCount; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        //int[] result = topologicalSortByBfs(nodeCount, adj);
        int[] result = topologicalSortByDfs(nodeCount, adj);

        System.out.println("Topological Sort of the given graph is:" + Arrays.toString(result));
    }

}
