package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 */
public class RatInAMazeProblemI {

    private static final int[][] NEIGHBOR_DIRECTIONS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public ArrayList<String> findPath(int[][] matrix, int matrixOrder) {
        ArrayList<String> result = new ArrayList<>();
        String prefix = "";
        if(matrix[matrixOrder - 1][matrixOrder - 1] == 0)
            return result;

        recursion(0, 0, matrix, matrixOrder, result, prefix);

        return result;
    }

    private void recursion(int rowIndex, int colIndex, int[][] matrix, final int matrixOrder, ArrayList<String> result, String prefix) {
        if((rowIndex == matrixOrder - 1 && colIndex == matrixOrder - 1)
            && matrix[rowIndex][colIndex] == 1) {
            result.add(prefix);
            return;
        }

        if(rowIndex < 0 || rowIndex > matrixOrder - 1 || colIndex < 0 || colIndex > matrixOrder - 1) {
            return;
        }

        if(matrix[rowIndex][colIndex] == 0) {//Cell is ZERO
            return;
        }

        if(matrix[rowIndex][colIndex] == Integer.MIN_VALUE) {//Already Visited
            return;
        }

        for(int count = 0; count < NEIGHBOR_DIRECTIONS.length; count++) {
            int temp = matrix[rowIndex][colIndex];
            matrix[rowIndex][colIndex] = Integer.MIN_VALUE;
            String direction = count == 0 ? "R" : (count == 1 ? "L" : (count == 2 ? "D" : "U"));

            recursion(rowIndex + NEIGHBOR_DIRECTIONS[count][0], colIndex + NEIGHBOR_DIRECTIONS[count][1], matrix, matrixOrder, result, prefix + direction);

            matrix[rowIndex][colIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        RatInAMazeProblemI sol = new RatInAMazeProblemI();
        System.out.println(sol.findPath(matrix, 4));
    }
}
