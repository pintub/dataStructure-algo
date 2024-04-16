package year2k21.common.pattern.dp.date21022023;

/**
 * https://leetcode.com/problems/maximal-square/solutions/600149/python-thinking-process-diagrams-dp-approach/
 * Space can be optimized
 */
public class MaximalSquare221 {

    public int maximalSquare(char[][] matrix) {
        int[][] memo = new int[matrix.length+1][matrix[0].length+1];

        int result = 0;

        for(int i = 0; i <= matrix.length ; i++ ) {
            for(int j = 0; j <= matrix[0].length ; j++ ) {
                if(i == 0 || j == 0)
                    continue;

                if(matrix[i-1][j-1] == '1') {
                    memo[i][j] = Math.min(Math.min(memo[i][j - 1], memo[i - 1][j]), memo[i - 1][j - 1]) + 1;
                    result = Math.max(result, memo[i][j]);
                }
            }
        }

        return result * result;
    }

    public int maximalSquare_SpaceOptimized(char[][] matrix) {
        int result = 0;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[] memo = new int[colSize + 1];//1D array

        int tempMemo = 0;

        //Virtual Memo Navigation
        for(int row = 0; row <= rowSize; row++) {
            for(int col = 0; col <= colSize; col++) {
                if(row == 0) {
                    memo[col] = 0;
                    continue;
                }
                if(col == 0) {
                    tempMemo = memo[col];
                    memo[col] = 0;
                    continue;
                }
                if(matrix[row - 1][col - 1] == '0') {
                    tempMemo = memo[col];
                    memo[col] = 0;
                } else {
                    int min = Math.min(
                            Math.min (memo[col], tempMemo),
                            memo[col - 1]
                    );
                    tempMemo = memo[col];
                    memo[col] = min + 1;
                    result = Math.max(result, memo[col]);
                }
            }
        }

        return result * result;
    }

    public static void main(String[] args) {
        MaximalSquare221 sol = new MaximalSquare221();
        System.out.println(sol.maximalSquare_SpaceOptimized(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
