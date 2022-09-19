package year2k21.common.pattern.general.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Special kind of grid-matrix-dfs starting in Grid graph, starting from (0,0) index
 * Aux Space =O(mn) due to call-stack
 * Time = O(mn)
 * Optimized solution :
 *      https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
 *      Right,Down,Left,Up in while loop
 *      Visited node check not required, solved nicely
 */
public class SpiralMatrix54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        dfs(0, 0, Direction.RIGHT, result, matrix);

        return result;
    }

    private void dfs(int rowIndex, int columnIndex, Direction fromDirection, List<Integer> result, int[][] matrix) {
        if(columnIndex >= matrix[0].length || columnIndex < 0) {
            return;
        }

        if(rowIndex >= matrix.length || rowIndex < 0) {
            return;
        }

        if(matrix[rowIndex][columnIndex] == Integer.MIN_VALUE) {//Integer.MIN_VALUE used for already visited cells
            return;
        }

        result.add(matrix[rowIndex][columnIndex]);
        int resultSize = result.size();
        matrix[rowIndex][columnIndex] = Integer.MIN_VALUE;

        //First try going in same direction
        childDfs(rowIndex, columnIndex, result, matrix, fromDirection);

        if(result.size() != resultSize) {
            return;
        }

        //If same direction walking is blocked, GO for next possible direction
        childDfs(rowIndex, columnIndex, result, matrix, fromDirection.getNext());
    }

    private void childDfs(int rowIndex, int columnIndex, List<Integer> result, int[][] matrix, Direction direction) {
        switch (direction) {
            case UP:
                dfs(rowIndex - 1, columnIndex, direction, result, matrix);
                break;
            case RIGHT:
                dfs(rowIndex, columnIndex + 1, direction, result, matrix);
                break;
            case DOWN:
                dfs(rowIndex + 1, columnIndex, direction, result, matrix);
                break;
            case LEFT:
                dfs(rowIndex, columnIndex - 1, direction, result, matrix);
                break;
        }
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN;

        public Direction getNext(){
            switch (this) {
                case UP:
                    return RIGHT;
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix54().spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}).equals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));

        System.out.println(new SpiralMatrix54().spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}).equals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7)));
    }
}
