package year2k21.common.pattern.graph.date11022023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges999 {

    public int orangesRotting(int[][] grid) {
        int rowLen= grid.length;
        int colLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> neighborDirections = Arrays.asList(new int[]{-1, 0},new int[]{0, -1},new int[]{1, 0}, new int[]{0, 1});

        int processedNodes = 0;
        for(int row = 0; row < rowLen; row++) {//Find all rotten cells
            for(int col =0; col < colLen; col++) {
                if(grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                    grid[row][col] = -1; //Mark Already visited
                    ++processedNodes;
                } else if(grid[row][col] == 0) {
                    grid[row][col] = -1; //Mark Already visited
                    ++processedNodes;
                }
            }
        }

        int minuteToRotGrid = 0;

        while(!queue.isEmpty()) {
            int queueLen = queue.size();
            for(int count =0; count < queueLen; count++ ) {
                int[] currentCell = queue.remove();
                for(int[] neighborDirection : neighborDirections) {
                    int neighborRowIndex = currentCell[0] + neighborDirection[0];
                    int neighborColIndex = currentCell[1] + neighborDirection[1];
                    if(neighborRowIndex < 0 || neighborColIndex < 0 || neighborRowIndex >= rowLen
                            || neighborColIndex >= colLen) {
                        continue;
                    }
                    if(grid[neighborRowIndex][neighborColIndex] == -1) {//Already visited
                        continue;
                    }

                    grid[neighborRowIndex][neighborColIndex] = -1;
                    ++processedNodes;
                    queue.add(new int[]{neighborRowIndex, neighborColIndex});
                }
            }

            if(queue.size() > 0)
                ++minuteToRotGrid;
        }

        if(processedNodes != rowLen * colLen)
            return -1;

        return minuteToRotGrid;
    }
}
