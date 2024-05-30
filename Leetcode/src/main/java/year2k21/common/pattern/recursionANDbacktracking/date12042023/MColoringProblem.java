package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 *
 * Could not solve, copied from Striver. Passed all testcases in GFG.
 *
 * Note: If you try to solve by BiPartiteGraph, they were issues while backtracking . So,Here instead of using dfs, traversing node one by one
 * Cause, BiPartiteGraph solution can start with assigning 1st node as 0 or 1 color. DFS does not backtrack nodeVsColorMap
 * In MColoringProblem, you need to experiment the color for each node, It needs backtracking
 *
 */
public class MColoringProblem {

    public boolean graphColoring(boolean[][] graph, int noOfColors, int noOfNodes) {
        Map<Integer, List<Integer>> adjList = buildAdjList(graph);
        Map<Integer, Integer> nodeVsColorMap = new HashMap<>();
        if (recursion(0, adjList, noOfNodes, noOfColors, nodeVsColorMap))
            return true;
        return false;
    }

    private static boolean recursion(int node, Map<Integer, List<Integer>> adjList, int noOfNodes, int noOfColors, Map<Integer, Integer> nodeVsColorMap) {
        if (node == noOfNodes)
            return true;

        for (int candidateColor = 1; candidateColor <= noOfColors; candidateColor++) {
            if (isSafe(node, adjList, candidateColor, nodeVsColorMap)) {//Check if any neighbor is already is using the candidateColor
                nodeVsColorMap.put(node, candidateColor);
                if (recursion(node + 1, adjList, noOfNodes, noOfColors, nodeVsColorMap))
                    return true;
                nodeVsColorMap.remove(node);
            }
        }
        return false;
    }

    private static boolean isSafe(int node, Map<Integer, List<Integer>> adjList,int color, Map<Integer, Integer> nodeVsColorMap) {
        if(adjList.get(node) != null) {
            for (int neighbor : adjList.get(node)) {
                if (nodeVsColorMap.get(neighbor) != null && nodeVsColorMap.get(neighbor) == color)
                    return false;
            }
        }
        return true;
    }
    
    private Map<Integer, List<Integer>> buildAdjList(boolean[][] graph) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int row = 0; row < graph.length; row++) {
            for(int col = 0; col < graph[0].length; col++) {
                if(row == col)//Handling Self-Loop
                    continue;
                if(graph[row][col]) {
                    List<Integer> temp = adjList.getOrDefault(row, new ArrayList<>());
                    temp.add(col);
                    adjList.put(row, temp);
                }
            }
        }

        return adjList;
    }

    public static void main(String[] args) {
        MColoringProblem sol = new MColoringProblem();

        boolean[][] graph1 = new boolean[][]{{false, true, true, true}, {true, false, true, false}, {true, true, false, true}, {true, false, true, false}};
        System.out.println(sol.graphColoring(graph1, 3, 4)); // true

        boolean[][] graph2 = new boolean[][]{{false, true, true}, {true, false, true}, {true, true, false}};
        System.out.println(sol.graphColoring(graph2, 2, 3)); // false
    }
}
