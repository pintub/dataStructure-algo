package com.p2.random.topinterviewques.date042024;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Not DP, as backward cycle exists
 *
 * A graph
 *  with unit edges
 *  cycles
 *  Directed
 *  Shortest Path from source to Target
 *
*  Shortest Path Type1 handles Directed Cycles as well
 *  Also Dijkstra's handles Directed Cycles
 */
public class SnakesAndLadders909 {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        int boardLen = board.length;
        int[] nodeVsDistanceFromSource = new int[boardLen * boardLen];
        for(int i= 0; i < boardLen * boardLen; i++) {
            nodeVsDistanceFromSource[i] = Integer.MAX_VALUE;
        }
        nodeVsDistanceFromSource[0] = 0;//Source Node
        queue.add(1);

        while (!queue.isEmpty()) {
            int currCell = queue.poll();
            int maxReach = Math.min(currCell + 6, boardLen * boardLen);
            for (int targetCell = currCell + 1; targetCell <= maxReach; targetCell++) {
                int cellVal = getValueByCellNum(targetCell, boardLen, board);

                int tempCell = targetCell;
                if(cellVal != -1) {
                    targetCell = cellVal;
                }
                //If incoming lesser
                if (nodeVsDistanceFromSource[currCell - 1] + 1 <
                        nodeVsDistanceFromSource[targetCell - 1]) {
                    nodeVsDistanceFromSource[targetCell - 1] = nodeVsDistanceFromSource[currCell - 1] + 1;
                    queue.add(targetCell);
                }

                targetCell = tempCell;//Short of Back-tracking
            }
        }

        int result = nodeVsDistanceFromSource[boardLen * boardLen - 1];
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int getValueByCellNum(int cell, final int boardLen, final int[][] board) {
        int row = (cell - 1) / boardLen;
        int rowIndex =  boardLen - 1 - row;

        int col = (cell - 1) % boardLen;
        int  colIndex = row % 2 == 0 ? col : boardLen - 1 - col;

        return board[rowIndex][colIndex];
    }

    public static void main(String[] args) {
        SnakesAndLadders909 sol = new SnakesAndLadders909();
        System.out.println(sol.snakesAndLadders(new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}) == 4);
        System.out.println(sol.snakesAndLadders(new int[][]{{-1,-1},{-1,3}}) == 1);
        System.out.println(sol.snakesAndLadders(new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}}) == 1);
    }
}
