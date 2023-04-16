package year2k21.common.pattern.general.matrix.date09042023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku36 {

    /**
     * Time  = O(9*9)
     * Space = O(9*9*3) for 3 Sets and each can have 9*9 numbers
     */
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> columns = new ArrayList<>(9);
        List<Set<Character>> cubes = new ArrayList<>(9);
        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            cubes.add(new HashSet<>());
        }

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.')
                    continue;
                char currentChar =  board[row][col];
                if(!rows.get(row).add(currentChar))
                    return false;
                if(!columns.get(col).add(currentChar))
                    return false;
                int cubeNumber = (row/3)*3 + col/3;
                if(!cubes.get(cubeNumber).add(currentChar))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
         */
        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku36 sol = new ValidSudoku36();
        System.out.println(sol.isValidSudoku(board));
    }
}
