package year2k21.common.pattern.graph.date16082022;

import year2k21.common.pattern.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/1126938/Short-and-Easy-w-Explanation-and-diagrams-or-Simple-Graph-traversals-DFS-and-BFS
 * Intuition: Water Floods from Lower to Higher Region
 * Result = {Atlantic Flood-able Cells} ∩ {Pacific Flood-able Cells}
 */

public class PacificAtlanticWaterFlow417 {

    /**
     * Start From top & left row cells and traverse via DFS, Find {Atlantic Flood-able Cells}
     * Start From bottom & right row cells and traverse via DFS, Find {Pacific Flood-able Cells}
     * Find intersection Set
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> atlanticFloodAbleCells = new ArrayList<>();//List of Cells
        List<List<Integer>> pacificFloodAbleCells = new ArrayList<>();//List of Cells
        List<List<Integer>> floodAbleCells = new ArrayList<>();
        Map<Pair<Integer, Integer>, Boolean> nodeVsVisitedFlag = new HashMap<>();

        //DFS Traverse Top row for Atlantic Flooding
        for(int j = 0; j < heights[0].length; j++){
            atlanticFloodAbleCells.addAll(getFloodAbleCellsViaDfs(0, j, nodeVsVisitedFlag, heights, Integer.MIN_VALUE));
        }

        //DFS Traverse Left row for Atlantic Flooding
        for(int i = 0; i < heights.length; i++){
            atlanticFloodAbleCells.addAll(getFloodAbleCellsViaDfs(i, 0, nodeVsVisitedFlag, heights, Integer.MIN_VALUE));
        }

        nodeVsVisitedFlag = new HashMap<>();

        //DFS Traverse Bottom row for Pacific Flooding
        for(int j = 0; j < heights[0].length; j++){
            pacificFloodAbleCells.addAll(getFloodAbleCellsViaDfs(heights.length - 1, j, nodeVsVisitedFlag, heights, Integer.MIN_VALUE));
        }

        //DFS Traverse Right row for Pacific Flooding
        for(int i = 0; i < heights.length; i++){
            pacificFloodAbleCells.addAll(getFloodAbleCellsViaDfs(i, heights[0].length - 1, nodeVsVisitedFlag, heights, Integer.MIN_VALUE));
        }

        //atlanticFloodAbleCells ∩ pacificFloodAbleCells
        for(List<Integer> floodAbleCell : pacificFloodAbleCells) {
            if(atlanticFloodAbleCells.contains(floodAbleCell)) {
                floodAbleCells.add(floodAbleCell);
            }
        }

        return floodAbleCells;
    }

    //Recursion
    private List<List<Integer>> getFloodAbleCellsViaDfs(int rowIdx, int colIdx, Map<Pair<Integer, Integer>, Boolean> nodeVsVisitedFlag, final int[][] heights, int predecessorCellHeight) {
        if(nodeVsVisitedFlag.get(new Pair<>(rowIdx, colIdx)) != null
            && nodeVsVisitedFlag.get(new Pair<>(rowIdx, colIdx))) {//Visited
            return Collections.emptyList();
        }

        if(rowIdx > heights.length - 1 || rowIdx < 0 ||
                colIdx > heights[0].length - 1 || colIdx < 0) {//invalid indices
            return Collections.emptyList();
        }

        if(heights[rowIdx][colIdx] < predecessorCellHeight) {//Current Cell height is lesser, so Can not flood. **NOTE**: Here not adding to nodeVsVisitedFlag, as it may want to visit this type of cell again, from another side of Ocean. This is little different from other Visited-DS usage
            return Collections.emptyList();
        }

        List<List<Integer>> floodAbleCells = new ArrayList<>();

        nodeVsVisitedFlag.put(new Pair<>(rowIdx, colIdx), true);

        int currentCellHeight = heights[rowIdx][colIdx];
        //4 Possible neighbors
        if(rowIdx > 0) { //Not Top row, so pay visit to upper cell
            floodAbleCells.addAll(getFloodAbleCellsViaDfs(rowIdx - 1, colIdx, nodeVsVisitedFlag, heights, currentCellHeight));
        }
        if(colIdx > 0) { //Not Left row, so pay visit to lefter cell
            floodAbleCells.addAll(getFloodAbleCellsViaDfs(rowIdx, colIdx - 1, nodeVsVisitedFlag, heights, currentCellHeight));
        }
        if(rowIdx < heights.length - 1) { //Not Bottom row, so pay visit to lower cell
            floodAbleCells.addAll(getFloodAbleCellsViaDfs(rowIdx + 1, colIdx, nodeVsVisitedFlag, heights, currentCellHeight));
        }
        if(colIdx < heights[0].length - 1) { //Not Right row, so pay visit to righter cell
            floodAbleCells.addAll(getFloodAbleCellsViaDfs(rowIdx, colIdx + 1, nodeVsVisitedFlag, heights, currentCellHeight));
        }

        floodAbleCells.add(Arrays.asList(rowIdx, colIdx));

        return floodAbleCells;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(new PacificAtlanticWaterFlow417().pacificAtlantic(heights));
    }
}
