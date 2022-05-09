package year2k21.common.pattern.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku
 * Classic example of invariant mismatch
 */
public class Solution37 {

    public void solveSudoku(char[][] board) {
        Set[] subBoxSet = new Set[9];
        Set[] rowSet = new Set[9];
        Set[] colSet = new Set[9];

        for(int row=0; row<9; row++) {
            for (int col=0; col<9; col++) {
                Set<Character> s = (rowSet[row] == null) ? new HashSet<>() : rowSet[row];
                s.add(board[row][col]);
                Set<Character> s1 = (colSet[col] == null) ? new HashSet<>() : colSet[col];
                s1.add(board[row][col]);
            }
        }
    }
}
