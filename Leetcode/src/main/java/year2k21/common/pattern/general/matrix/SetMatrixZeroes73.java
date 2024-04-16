package year2k21.common.pattern.general.matrix;

/**
 * Couldn't solve, copied from https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
 *
 * So, we need m+n space to store if any column or row has a zero.
 * <<ABOVE IS BEGINNING OF BELOW BEAUTIFUL LOGIC>>
 *
 * Instead of using auxiliary space, you can use 1st row + 1st column to store info about which cells have "0"
 * How ? Example After using above mechanism , if arr[0][j] = 0,means jth column has a 0
 * if arr[i][0] = 0,means ith row has a 0
 * How to know if 1st column or 1st row has "0", use another 2 variables (isFirstRowHasZero, isFirstColumnHasZero)
 *
 * 2nd loop: 
     From 2nd row and 2nd column, and update cell as Zero if matrix[i][0] == 0 Or matrix[0][j] == 0
     (Why not 1st row and 1st column, Updating them will impact other cells)
 * 
 * Next, Update 1st row and 1st column using (isFirstRowHasZero, isFirstColumnHasZero) vars
 *
 * Time = O(m*n)
 * Space = O(1)
 */
public class SetMatrixZeroes73 {

    //BASICALLY Maintain state of 0s' in 1st row + 1st column + isFirstRowHasZero + isFirstColumnHasZero
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowHasZero = false,isFirstColumnHasZero = false;

        for(int i = 0; i < matrix.length; i++) {//Time = O(m*n)
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) isFirstRowHasZero = true;
                    if(j == 0) isFirstColumnHasZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //Iterate again and based on above representation, set neighboring cell as "0"
        for(int i = 1; i < matrix.length; i++) {//Time = O(m - 1 * n - 1)
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Below Lines has to be in this sequence, i.e. can not be combined with above 2-for loop
        //Handle 1st row, if it has 0
        if(isFirstRowHasZero) {//Time = O(n)
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //Handle 1st column, if it has 0
        if(isFirstColumnHasZero) {//Time = O(m)
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
