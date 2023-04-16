package year2k21.common.pattern.general.matrix.date09042023;

/**
 * Time =
 *  = O(m*n) * 4 ^ wordLen
 *  Space = O(wordLen) because of Recursion
 */
public class WordSearch79 {

    private final static int[][] NEIGHBOR_DIRECTIONS = new int[][]{{0,1}, {0,-1},{-1,0},{1,0}};

    public boolean exist(char[][] board, String word) {
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for(int colIndex = 0; colIndex < board[0].length; colIndex++) {
                if(exist(rowIndex, colIndex, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int rowIndex, int colIndex, char[][] board, String word, int wordIndex) {
        if(wordIndex == word.length()) {
            return true;
        }
        if(rowIndex < 0 || rowIndex > board.length - 1 || colIndex < 0 || colIndex > board[0].length - 1) {
            return false;
        }
        if(board[rowIndex][colIndex] == '#') {
            return false;
        }
        if(word.charAt(wordIndex) != board[rowIndex][colIndex]){
            return false;
        }

        char temp = board[rowIndex][colIndex];
        board[rowIndex][colIndex] = '#';

        boolean isWordFound = false;
        for(int[] neighborDirection : NEIGHBOR_DIRECTIONS) {
            if(exist(rowIndex + neighborDirection[0], colIndex + neighborDirection[1], board, word, wordIndex + 1)) {
                isWordFound = true;
                break;
            }
        }

        board[rowIndex][colIndex] = temp;
        return isWordFound;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch79 sol = new WordSearch79();
        System.out.println(sol.exist(board, "ABCCED"));//true
        System.out.println(sol.exist(board, "SEE"));//true
        System.out.println(sol.exist(board, "ABCB"));//false
    }
}
