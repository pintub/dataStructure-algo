package year2k21.common.pattern.general.matrix.date09042023;

import java.util.Arrays;

/**
 *
 * Couldn't solve
 *
 * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
 *
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * after transpose, it will be swap(matrix[i][j], matrix[j][i])
 *
 * 1  4  7
 * 2  5  8
 * 3  6  9
 * Then flip the matrix around vertical axis. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
 *
 * 7  4  1
 * 8  5  2
 * 9  6  3
 *
 * https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
 */
public class RotateImage48 {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }

    private void transpose(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(row > col || matrix[row][col] == matrix[col][row])
                    continue;
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }

    private void flip(int[][] matrix) {
        int colLen = matrix[0].length;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length / 2; col++) {
                int colSwapIndex = colLen - 1 - col;
                if(matrix[row][col] == matrix[row][colSwapIndex])
                    continue;
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][colSwapIndex];
                matrix[row][colSwapIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        year2k21.common.pattern.general.matrix.RotateImage48 sol = new year2k21.common.pattern.general.matrix.RotateImage48();
        sol.rotate(matrix);
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

}

