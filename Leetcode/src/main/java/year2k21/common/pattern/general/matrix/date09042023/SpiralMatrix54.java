package year2k21.common.pattern.general.matrix.date09042023;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        dfs(0, 0, matrix, result, FromDirection.LEFT);

        return result;
    }

    private void dfs(int rowIndex, int colIndex, final int[][] matrix, List<Integer> result, final FromDirection fromDirection) {
        if(rowIndex < 0
                || rowIndex > matrix.length - 1
                || colIndex < 0
                || colIndex > matrix[0].length - 1) {
            return;
        }

        if(matrix[rowIndex][colIndex] == Integer.MIN_VALUE) {
            return;
        }

        result.add(matrix[rowIndex][colIndex]);

        int tempSize = result.size();
        matrix[rowIndex][colIndex] = Integer.MIN_VALUE;

        if(fromDirection == FromDirection.LEFT) {
            dfs(rowIndex, colIndex + 1, matrix, result, FromDirection.LEFT);//RIGHT
            if (tempSize != result.size()) {
                return;
            }

            dfs(rowIndex + 1, colIndex, matrix, result, FromDirection.UP);//DOWN
        }
        if(fromDirection == FromDirection.RIGHT) {
            dfs(rowIndex, colIndex - 1, matrix, result, FromDirection.RIGHT);//LEFT
            if (tempSize != result.size()) {
                return;
            }

            dfs(rowIndex - 1, colIndex, matrix, result, FromDirection.DOWN);//UP
        }
        if(fromDirection == FromDirection.UP) {
            dfs(rowIndex + 1, colIndex, matrix, result, FromDirection.UP);//DOWN
            if (tempSize != result.size()) {
                return;
            }

            dfs(rowIndex, colIndex - 1, matrix, result, FromDirection.RIGHT);//LEFT
        }
        if(fromDirection == FromDirection.DOWN) {
            dfs(rowIndex - 1, colIndex, matrix, result, FromDirection.DOWN);//UP
            if (tempSize != result.size()) {
                return;
            }

            dfs(rowIndex, colIndex + 1, matrix, result, FromDirection.LEFT);//RIGHT
        }
    }

    private enum FromDirection {
        LEFT,
        RIGHT,
        DOWN,
        UP
    }

    public static void main(String[] args) {
        SpiralMatrix54 sol = new SpiralMatrix54();
        //int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println(sol.spiralOrder(matrix));//1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
    }
}
