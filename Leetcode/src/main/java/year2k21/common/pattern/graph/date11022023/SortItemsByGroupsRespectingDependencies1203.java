package year2k21.common.pattern.graph.date11022023;

import java.util.List;

/**
 * Could not solve
 *
 * Referred Solution :
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/solutions/389805/java-topological-sort-detailed-explanation/?orderBy=most_votes
 *
 * Question demands topo sorting of both Group and items .AND no cycle should be There
 *  - Build AdjList or Graph for Group . NOTE: If an element is in no-group(denoted as -1 in question), Create a new group each such element
 *  - Build AdjList or Graph for Item
 *  - Topo sort Group adjList, Check if any Cycle
 *  - Topo sort Item adjList, Check if any Cycle
 *  - If either has cycle, return . ELSE Build GroupVsItemsListMap from "Item adjList"
 *      - Traverse GroupVsItemsListMap, flatten to array and Return
 */
public class SortItemsByGroupsRespectingDependencies1203 {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        return null;
    }
}
