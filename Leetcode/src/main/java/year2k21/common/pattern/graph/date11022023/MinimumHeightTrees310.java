package year2k21.common.pattern.graph.date11022023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees310 {

    //Trick is at the end 1 or 2 nodes will be last-men-standing
    public List<Integer> findMinHeightTrees(final int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        int processedNodeCount = 0;
        while (n - processedNodeCount > 2) {
            processedNodeCount += leaves.size();
            List<Integer> newLeaves = new ArrayList<>(); //New List is used unlike BFS which uses same Q
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees310 sol = new MinimumHeightTrees310();
        System.out.println(sol.findMinHeightTrees(4, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
}
