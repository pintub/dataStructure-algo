package year2k21.common.pattern.general.matrix.date09042023;

import java.util.Arrays;

public class SetMatrixZeroes73 {

    public void setZeroes(int[][] matrix) {
        boolean isFirstRowHasZero = false, isFirstColumnHasZero = false;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    if(row == 0) {
                        isFirstRowHasZero = true;
                    }
                    if(col == 0) {
                        isFirstColumnHasZero = true;
                    }
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                 }
            }
        }

        for(int row = 1; row < matrix.length; row++) {
            for(int col = 1; col < matrix[0].length; col++) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isFirstColumnHasZero) {
            for (int row = 0; row < matrix.length; row++) {

                matrix[row][0] = 0;
            }
        }

        if (isFirstRowHasZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes73 sol = new SetMatrixZeroes73();
        //int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        sol.setZeroes(matrix);
        Arrays.stream(matrix).forEach(oneDArray -> System.out.println(Arrays.toString(oneDArray)));
    }

}
