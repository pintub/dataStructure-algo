package com.p2.graph;

import com.p2.*;

import java.util.*;

import static com.p2.graph.ShortestPathInGraph.findSourceToDestinationDistance;

public class MinimalSpanningTree {

    private int minimalSpanningTreeByKruskalAlgorithm(int nodeCount, ArrayList<ArrayList<Pair<Integer, Integer>>> adjListWeighted, int anyNode) {
        return 0;
    }

    /**
     * <Pair> = <Node, Weight>
     *  Literally copied most code from {@link com.p2.graph.ShortestPathInGraph#shortestPathUnDirectedGraphNonUnitWeight(int, java.util.ArrayList, int)} :(
     */
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
}
