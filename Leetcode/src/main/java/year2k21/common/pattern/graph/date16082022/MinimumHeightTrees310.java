package year2k21.common.pattern.graph.date16082022;

import java.util.*;

/**
 * Could not think of solution, Referred LeetCode
 * Intuition : https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts/185455
 * Start with nodes with ZeroOutDegree and converge to middle points.Similar to TopoSort BFS problem( instead of ZeroInDegree concept). Output will be always 1 or 2 nodes
 *
 */
public class MinimumHeightTrees310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>(2);//Output will be always 1 or 2 nodes
        Map<Integer, Set<Integer>> adjList = new HashMap<>(); //Set as there is a delete operation

        if(edges.length == 0) {//Edge-, 1 node
            return Collections.singletonList(0);
        }

        if(edges.length == 1) {//Edge-case, 2 node
            result.add(edges[0][1]);
            result.add(edges[0][0]);

            return result;
        }

        //Build Adjacency list of Graph
        for(int[] edge : edges) {
            Set<Integer> neighbors = adjList.getOrDefault(edge[0], new HashSet<>());
            neighbors.add(edge[1]);
            adjList.put(edge[0], neighbors);

            neighbors = adjList.getOrDefault(edge[1], new HashSet<>());
            neighbors.add(edge[0]);
            adjList.put(edge[1], neighbors);
        }

        //Queue<Integer> queue = new LinkedList<>();

        List<Integer> leaveList = new ArrayList<>(findNodeWithZeroOutDegree(adjList));
        //queue.addAll(leaveList);
        int processedLeafCount = leaveList.size();
        while (!leaveList.isEmpty()) {
            List<Integer> newLeaves = new ArrayList<>();//New List is used unlike BFS which uses same Q
            for(int leaf : leaveList) {
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove((Integer) leaf);
                if(adjList.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                }
            }

            leaveList = newLeaves;
            processedLeafCount += newLeaves.size();

            if(n == processedLeafCount) {
                break;
            }
        }
        return leaveList;
    }

    //If Only One neighbor is there
    private Set<Integer> findNodeWithZeroOutDegree(Map<Integer, Set<Integer>> adjList) {
        Set<Integer> result = new HashSet<>();
        for(int node : adjList.keySet()) {
            if(adjList.get(node) != null && adjList.get(node).size() == 1) {
                result.add(node);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};
        //int[][] edges = new int[][] {};
        //int[][] edges = new int[][] {{0,1}};

        System.out.println(new MinimumHeightTrees310().findMinHeightTrees(6, edges));
    }
}
