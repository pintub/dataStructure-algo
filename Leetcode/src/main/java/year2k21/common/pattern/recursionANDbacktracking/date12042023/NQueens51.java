package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time = 2^n tries
 *
 * Thought Process:
 *    It's not about whether a cell to contain 'Q' or '.'
 *     Rather it's about for a row, whether a column to contain 'Q' or '.'
 *
 *  Late Note:
 *      isValid() can be optimized, you can keep track of occupiedCol, occupiedRightDiagonal, occupiedLeftDiagonal list . Also Backtrack.
 *      https://leetcode.com/problems/n-queens-ii/solutions/20058/accepted-java-solution/?envType=study-plan-v2&envId=top-interview-150
 */
public class NQueens51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        recursion(0, n, result, new ArrayList<>());

        return result;
    }

    private void recursion(int rowNum, int n, List<List<String>> result, ArrayList<String> prefix) {
        if(rowNum == n) {
            result.add(new ArrayList<>(prefix));
            return;
        }

        for(int colNum = 0; colNum < n; colNum++) {
            if(isValid(prefix, rowNum, colNum, n)) {//If current position for Q is valid
                prefix.add(convertToString(colNum, n));
                recursion(rowNum + 1, n, result, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    //O(n)
    private String convertToString(int colNum, int n) {
        StringBuilder sb = new StringBuilder();
        for(int count = 0; count < n; count++) {
            if(count != colNum) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }

    //O(prefixSize * n)
    private boolean isValid(ArrayList<String> prefix, int targetRowNum, int targetColNum, int n) {
        Set<Integer> restrictedColumns = new HashSet<>();
        for(int row = 0; row < prefix.size(); row++) {
            String currentStr = prefix.get(row);
            for(int colIndex = 0; colIndex < currentStr.length(); colIndex++) {
                if(currentStr.charAt(colIndex) == 'Q') {
                    restrictedColumns.add(colIndex);

                    int rightDiagonalColumnIndex = colIndex + (targetRowNum - row);
                    if(rightDiagonalColumnIndex < n)
                        restrictedColumns.add(rightDiagonalColumnIndex);
                    int leftDiagonalColumnIndex = colIndex - (targetRowNum - row);
                    if(leftDiagonalColumnIndex >= 0)
                        restrictedColumns.add(leftDiagonalColumnIndex);
                }
            }
        }

        return restrictedColumns.add(targetColNum);
    }

    public static void main(String[] args) {
        NQueens51 sol = new NQueens51();
        System.out.println(sol.solveNQueens(4));//[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
        System.out.println(sol.solveNQueens(1));//[[Q]]
        System.out.println(sol.solveNQueens(3));//[]
    }

}
