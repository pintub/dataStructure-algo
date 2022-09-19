package com.p2.graph;

import com.p2.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

//Disclaimer : UnTested
/**
 * Only source Given, find the shortest path from source to all other nodes. Returns distance[]
 * 3 variants :
 *   UnDirected Unit weighted Graph (BFS)
 *   Weighted DAG (Using Topological sorting), Notice input Graph representation of weighted Graphs
 *   UnDirected non-Unit non-negative Weighted Graph (Dijkstra's algo), Notice input Graph representation of weighted Graphs
 *
 */
public class ShortestPathInGraph {

    private int[] shortestPathUnDirectedGraphUnitWeight(int nodeCount, List<List<Integer>> adjList, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        int[] nodeVsDistanceFromSourceMap = new int[nodeCount];
        for(int node = 0; node < nodeCount; node++) {//nodeVsDistanceFromSourceMap initialized to ∞
            nodeVsDistanceFromSourceMap[node] = Integer.MAX_VALUE;
        }

        queue.add(sourceNode);
        nodeVsDistanceFromSourceMap[sourceNode] = 0;

        while (!queue.isEmpty()) {
            int current = queue.remove();

            for(int neighbor : adjList.get(current)) {
                if(nodeVsDistanceFromSourceMap[neighbor] != Integer.MAX_VALUE) {//Already visited
                    continue;
                }

                nodeVsDistanceFromSourceMap[neighbor] = nodeVsDistanceFromSourceMap[current] + 1;
                queue.add(neighbor);
            }
        }

        return nodeVsDistanceFromSourceMap;
    }

    //<Pair> = <Node, distanceFromSrouce>
    //Literally copied most of code from shortestPathUnDirectedGraphUnitWeight() :(
    private int[] shortestPathUnDirectedGraphNonUnitWeight(int nodeCount, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted, int sourceNode) {
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair1.right, pair2.right));//Comparing distanceFromSrouce
        int[] nodeVsDistanceFromSourceMap = new int[nodeCount];
        for(int node = 0; node < nodeCount; node++) {//nodeVsDistanceFromSourceMap initialized to ∞
            nodeVsDistanceFromSourceMap[node] = Integer.MAX_VALUE;
        }

        nodeVsDistanceFromSourceMap[sourceNode] = 0;
        queue.add(new Pair<>(sourceNode, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentNodeVsDistanceFromSource = queue.remove();

            for (Pair<Integer,Integer> neighborPair : adjListWeighted.get(currentNodeVsDistanceFromSource.left)) {
                if(
                        nodeVsDistanceFromSourceMap[currentNodeVsDistanceFromSource.left] + findSourceToDestinationDistance(currentNodeVsDistanceFromSource.left, neighborPair.left, adjListWeighted)
                        <
                        nodeVsDistanceFromSourceMap[neighborPair.left]
                ) {//Incoming value < existing value, Push to Queue
                    nodeVsDistanceFromSourceMap[neighborPair.left] = Math.min(
                            nodeVsDistanceFromSourceMap[neighborPair.left],
                            nodeVsDistanceFromSourceMap[currentNodeVsDistanceFromSource.left] + findSourceToDestinationDistance(currentNodeVsDistanceFromSource.left, neighborPair.left, adjListWeighted));
                    queue.add(new Pair<>(neighborPair.left, nodeVsDistanceFromSourceMap[neighborPair.left]));
                }
            }
        }

        return nodeVsDistanceFromSourceMap;
    }

    //<Pair> = <Node, distanceFromSrouce>
    private int[] shortestPathWeightedDAG(int nodeCount, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted, int sourceNode) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (ArrayList<Pair<Integer, Integer>> neighborPairList : adjListWeighted) {
            ArrayList<Integer> neighborNodes = (ArrayList<Integer>) neighborPairList.stream().map(neighborPair -> neighborPair.left).collect(Collectors.toList());

            adjList.add(neighborNodes);
        }

        int[] sortedNodes = TopologicalSort.topologicalSortByDfs(nodeCount, adjList);
        int[] nodeVsDistanceFromSourceMap = new int[nodeCount];
        for(int node = 0; node < nodeCount; node++) {//nodeVsDistanceFromSourceMap initialized to ∞
            nodeVsDistanceFromSourceMap[node] = Integer.MAX_VALUE;
        }

        nodeVsDistanceFromSourceMap[sourceNode] = 0;

        for(int node : sortedNodes) {
            if(nodeVsDistanceFromSourceMap[node] == Integer.MAX_VALUE) {//Nodes appearing before source node in sorted order are not reachable from source, OF-COURSE . if sorting is [5423] & 2 is source, 5/4 not reachable from 2.
                continue;
            }

            for(int neighbor : adjList.get(node)) {
                nodeVsDistanceFromSourceMap[neighbor] = Math.min(
                        nodeVsDistanceFromSourceMap[neighbor],
                        nodeVsDistanceFromSourceMap[node] + findSourceToDestinationDistance(node, neighbor, adjListWeighted));
            }
        }

        return null;
    }

    public static int findSourceToDestinationDistance(int source, int destination, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted) {
        ArrayList<Pair<Integer, Integer>> neighborPairs = adjListWeighted.get(source);
        for(Pair<Integer, Integer> neighborPair : neighborPairs) {
            if(neighborPair.left == destination) {
                return neighborPair.right;
            }
        }

        return Integer.MAX_VALUE;
    }
}
