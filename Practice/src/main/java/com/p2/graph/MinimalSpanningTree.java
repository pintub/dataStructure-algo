package com.p2.graph;

import com.p2.*;

import java.util.*;

import static com.p2.graph.ShortestPathInGraph.findSourceToDestinationDistance;

public class MinimalSpanningTree {

    /**
     * Using Disjoint Sets with Path Compression + By Height
     *
     * Input is list of edges
     * Returns list of edges which will be part of MST
     */
    public Map<Pair<Integer, Integer>, Integer> minimalSpanningTreeByKruskalAlgorithm(int nodeCount, Map<Pair<Integer, Integer>, Integer> nodePairVsWeight) {
        Set<Map.Entry<Pair<Integer, Integer>, Integer>> sortedEdges = new TreeSet<>((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()));
        sortedEdges.addAll(nodePairVsWeight.entrySet());

        Map<Pair<Integer, Integer>, Integer> result = new HashMap<>();

        //Initialize Disjoint Sets
        int[] disjointSetArray = new int[nodeCount];
        for(int count=0; count < nodeCount; count++) {
            disjointSetArray[count] = -1;
        }

        for (Map.Entry<Pair<Integer, Integer>, Integer> edge : sortedEdges) {
            int leftRoot = findDisjointSet(disjointSetArray, edge.getKey().left);
            int rightRoot = findDisjointSet(disjointSetArray, edge.getKey().right);
            if(unionDisjointSet(disjointSetArray, leftRoot, rightRoot)) {
                result.put(edge.getKey(), edge.getValue());
            }
        }

        return result;
    }

    //Returns Root
    private int findDisjointSet(int[] disjointSetArray, int element) {
        if(disjointSetArray[element] < 0) {
            return element;
        }

        int root = findDisjointSet(disjointSetArray, disjointSetArray[element]);

        disjointSetArray[element] = root;

        return root;
    }

    /**
     * Slightly modified regular union()
     * Returning true if join of sets happen, else false
     */
    private boolean unionDisjointSet(int[] disjointSetArray, int leftRoot, int rightRoot) {
        if(leftRoot == rightRoot) {//Already part of same Set
            return false;
        }

        if(disjointSetArray[leftRoot] == disjointSetArray[rightRoot]) {
            disjointSetArray[leftRoot] += -1;
            disjointSetArray[rightRoot] = leftRoot;
        } else if(disjointSetArray[leftRoot] < disjointSetArray[rightRoot]) { //left Tree is Bigger
            disjointSetArray[rightRoot] = leftRoot;
        } else {
            disjointSetArray[leftRoot] = rightRoot;
        }

        return true;
    }

    /**
     * <Pair> = <Node, Weight>
     *  Literally copied most code from {@link com.p2.graph.ShortestPathInGraph#shortestPathUnDirectedGraphNonUnitWeight(int, java.util.ArrayList, int)} :(
     */
    public int minimalSpanningTreeByPrimAlgorithm(int nodeCount, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted) {
        return minimalSpanningTreeByPrimAlgorithm(nodeCount, adjListWeighted, 0);
    }

    private int minimalSpanningTreeByPrimAlgorithm(int nodeCount, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted, int anyNode) {
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair1.right, pair2.right));//Comparing Weight
        int[] nodeVsWeightOfSelectedEdge = new int[nodeCount];
        int[] nodeVsOtherSideNodeOfSelectedEdge = new int[nodeCount];//this map at end helps in building MST
        for(int node = 0; node < nodeCount; node++) {//nodeVsWeightOfSelectedEdge initialized to ∞
            nodeVsWeightOfSelectedEdge[node] = Integer.MAX_VALUE;
        }

        nodeVsWeightOfSelectedEdge[anyNode] = 0;
        nodeVsOtherSideNodeOfSelectedEdge[anyNode] = -1;
        queue.add(new Pair<>(anyNode, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentNodeVsWeightOfSelectedEdge = queue.remove();

            for (Pair<Integer,Integer> neighborPair : adjListWeighted.get(currentNodeVsWeightOfSelectedEdge.left)) {
                if(
                        findSourceToDestinationDistance(currentNodeVsWeightOfSelectedEdge.left, neighborPair.left, adjListWeighted)
                                <
                        nodeVsWeightOfSelectedEdge[neighborPair.left]
                ) {//Incoming value < existing value, Push to Queue
                    nodeVsWeightOfSelectedEdge[neighborPair.left] =
                            findSourceToDestinationDistance(currentNodeVsWeightOfSelectedEdge.left, neighborPair.left, adjListWeighted);
                    nodeVsOtherSideNodeOfSelectedEdge[neighborPair.left] = currentNodeVsWeightOfSelectedEdge.left;
                    queue.add(new Pair<>(neighborPair.left, nodeVsWeightOfSelectedEdge[neighborPair.left]));
                }
            }
        }

        return Arrays.stream(nodeVsWeightOfSelectedEdge).sum();
    }

    public static void main(String[] args) {
    }

}
