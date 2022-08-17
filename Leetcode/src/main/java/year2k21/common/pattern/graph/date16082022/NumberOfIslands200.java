package year2k21.common.pattern.graph.date16082022;

//Grid Graph
//number of disconnected components
public class NumberOfIslands200 {

    public int numIslands(char[][] grid) {
        boolean[][] cellVsVisitedMap = new boolean[grid.length][grid[0].length];
        int disconnectedComponentCount = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(cellVsVisitedMap[row][col]) {
                    continue;
                }

                if(grid[row][col] == '0'){
                    continue;
                }

                disconnectedComponentCount++;

                dfs(row, col, cellVsVisitedMap, grid);
            }
        }

        return disconnectedComponentCount;
    }

    private void dfs(int rowIdx, int colIdx, boolean[][] cellVsVisitedMap, final char[][] grid) {
        if(cellVsVisitedMap[rowIdx][colIdx]){
            return;
        }

        if(grid[rowIdx][colIdx] != '1') {//only 0->1 & 1->1 allowed
            return;
        }

        cellVsVisitedMap[rowIdx][colIdx] = true;

        //4 Possible neighbors
        if(rowIdx > 0) { //Not Top row, so pay visit to upper cell
            dfs(rowIdx - 1, colIdx, cellVsVisitedMap, grid);
        }
        if(colIdx > 0) { //Not Left row, so pay visit to lefter cell
            dfs(rowIdx, colIdx - 1, cellVsVisitedMap, grid);
        }
        if(rowIdx < grid.length - 1) { //Not Bottom row, so pay visit to lower cell
            dfs(rowIdx + 1, colIdx, cellVsVisitedMap, grid);
        }
        if(colIdx < grid[0].length - 1) { //Not Right row, so pay visit to righter cell
            dfs(rowIdx, colIdx + 1, cellVsVisitedMap, grid);
        }
    }

    public static void main(String[] args) {
        /*char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };*/

        char[][] grid = new char[][]
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };

        System.out.println(new NumberOfIslands200().numIslands(grid));
    }
}
