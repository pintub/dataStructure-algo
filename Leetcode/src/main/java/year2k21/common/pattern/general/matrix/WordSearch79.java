package year2k21.common.pattern.general.matrix;

/**
 * grid-matrix-dfs
 *      Time = O(mn)*O(mn) (for each cell traverse the grid to see if word exists)
 *      Important space = Not O(mn) , but O(worLength) Think...Think...
 *
 * Idea :
 *          For each cell, perform DFS
 *          TO mark visited node starting a cell having "a", 1st convert to "/" , then while returning from recursion call restore state back to "a"
 *
 */
public class WordSearch79 {

    public boolean exist(char[][] board, String word) {

        return false;
    }

}
