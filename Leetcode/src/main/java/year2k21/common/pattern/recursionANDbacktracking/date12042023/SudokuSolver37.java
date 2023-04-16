package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.Arrays;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        if(!recursion(board)){
            System.out.println("WHOAA!! How I Reached, There is always one solution as Per Question");
        }
    }

    public boolean recursion(char[][] board) {
        for(int rowIndex = 0; rowIndex < 9 ; rowIndex++) {
            for(int colIndex = 0; colIndex < 9; colIndex++) {
                if(board[rowIndex][colIndex] != '.') {
                    continue;
                }

                for(int candidate = 1; candidate <= 9; candidate++) {
                    if(!isValidCandidate(board, candidate, rowIndex, colIndex)) {
                        continue;
                    }
                    board[rowIndex][colIndex] = ("" + candidate).charAt(0);
                    if(recursion(board)) {
                        return true;
                    }
                    board[rowIndex][colIndex] = '.';
                }
                return false;
            }
        }
        return true;
    }

    //O(2n)
    private boolean isValidCandidate(char[][] board, int candidate, int rowIndex, int colIndex) {
        char candidateChar = ("" + candidate).charAt(0);
        for(int i = 0; i < 9; i++) {
            if(board[rowIndex][i] == candidateChar) {
                return false;
            }

            if(board[i][colIndex] == candidateChar) {
                return false;
            }
        }

        int topLeftLocationRowIndex = (rowIndex / 3) * 3;
        int topLeftLocationColumnIndex = (colIndex / 3) * 3;
        for(int i = 0; i < 3 ; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[topLeftLocationRowIndex + i][topLeftLocationColumnIndex + j] == candidateChar) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuSolver37 sol = new SudokuSolver37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sol.solveSudoku(board);
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
