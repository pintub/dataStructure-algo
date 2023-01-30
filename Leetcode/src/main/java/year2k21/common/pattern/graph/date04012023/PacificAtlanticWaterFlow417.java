package year2k21.common.pattern.graph.date04012023;

import year2k21.common.pattern.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow417 {

    Set<Pair<Integer, Integer>> visitedCells = new HashSet<>();
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        final int rowLength = heights.length;
        final int colLength = heights[0].length;
        Set<Pair<Integer, Integer>> pacificFloodedCells = new HashSet<>();
        Set<Pair<Integer, Integer>> atlanticFloodedCells = new HashSet<>();

        for(int col = 0; col < colLength; col++) {
            if(visitedCells.contains(new Pair<>(0, col))) {
                continue;
            }

            dfs(0, col, rowLength, colLength, Integer.MIN_VALUE, pacificFloodedCells);
        }

        for(int row = 0; row < rowLength; row++) {
            if(visitedCells.contains(new Pair<>(row, 0))) {
                continue;
            }

            dfs(row, 0, rowLength, colLength, Integer.MIN_VALUE, pacificFloodedCells);
        }
        visitedCells.clear();
        for(int col = 0; col < colLength; col++) {
            if(visitedCells.contains(new Pair<>(rowLength - 1, col))) {
                continue;
            }

            dfs(rowLength - 1, col, rowLength, colLength, Integer.MIN_VALUE, atlanticFloodedCells);
        }

        for(int row = 0; row < rowLength; row++) {
            if(visitedCells.contains(new Pair<>(row, colLength - 1))) {
                continue;
            }

            dfs(row, colLength - 1, rowLength, colLength, Integer.MIN_VALUE, atlanticFloodedCells);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Pair<Integer, Integer> pacificFloodedCell : pacificFloodedCells) {
            if(atlanticFloodedCells.contains(pacificFloodedCell)) {
                result.add(Arrays.asList(pacificFloodedCell.left, pacificFloodedCell.right));
            }
        }

        return result;
    }

    private void dfs(int rowIndex, int columnIndex, final int rowLength, final int columnLength, int predecessorCellHeight, Set<Pair<Integer, Integer>> floodAbleCells) {
        if(visitedCells.contains(new Pair<>(rowIndex, columnIndex))) {
            return;
        }

        int currentCellHeight = heights[rowIndex][columnLength];

        if(currentCellHeight < predecessorCellHeight) {
            return;
        }

        Pair<Integer, Integer> currentCell = new Pair<>(rowIndex, columnIndex);
        visitedCells.add(currentCell);
        floodAbleCells.add(currentCell);

        if(rowIndex + 1 < rowLength) {
            dfs(rowIndex + 1, columnIndex, rowLength, columnLength, currentCellHeight, floodAbleCells);
        }

        if(columnIndex + 1 < columnLength) {
            dfs(rowIndex, columnIndex + 1, rowLength, columnLength, currentCellHeight, floodAbleCells);
        }

        if(rowIndex - 1 >= 0) {
            dfs(rowIndex - 1, columnIndex, rowLength, columnLength, currentCellHeight, floodAbleCells);
        }

        if(columnIndex - 1 >= 0) {
            dfs(rowIndex, columnIndex - 1, rowLength, columnLength, currentCellHeight, floodAbleCells);
        }
    }
}
