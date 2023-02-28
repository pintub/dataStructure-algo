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

    public static void main(String[] args) {
        MaximalSquare221 sol = new MaximalSquare221();
        System.out.println(sol.maximalSquare(new char[][]{{'0', '1'}}));
    }
}
