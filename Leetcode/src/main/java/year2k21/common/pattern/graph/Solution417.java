package year2k21.common.pattern.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Could nt solve
 * https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/1126938/Short-and-Easy-w-Explanation-and-diagrams-or-Simple-Graph-traversals-DFS-and-BFS
 * explaintation
 */
public class Solution417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        Pair[][] cache = new Pair[heights.length][heights[0].length];
        int[][] visited = new int[heights.length][heights[0].length];

        for(int row=0; row<heights.length; row++) {
            for (int col=0; col < heights[0].length; col++) {
                if(visited[row][col] != 0) {//visited
                    continue;
                }
                canFlow(row, col, cache, heights.length, heights[0].length, heights);
            }
        }

        for(int row=0; row<cache.length; row++) {
            for (int col=0; col < cache[0].length; col++) {
                if(cache[row][col].canFlowAtl && cache[row][col].canFlowPac) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }

    private Pair canFlow(int row, int col, Pair[][] cache, int rowLen, int colLen, int[][] heights) {
        System.out.println("Row:"+row + "," +"Column:" + col );
        if(row == -1 || col == -1)
            return new Pair(true, false);
        if(row == rowLen || col == colLen)
            return new Pair(false, true);

        if(cache[row][col] != null) {
            return cache[row][col];
        }

        //Visit 4 Neighbors
        Pair sumPair = new Pair();
        if((row > 0 && heights[row-1][col] <= heights[row][col]) || row == 0) {
            Pair pair = canFlow(row - 1, col, cache, rowLen, colLen, heights);//top
            sumPair = sumPair(sumPair, pair);
            if(sumPair.canFlowAtl && sumPair.canFlowPac){
                cache[row][col] = sumPair;
                return sumPair;
            }
        }
        if((col > 0 && heights[row][col-1] <= heights[row][col]) || col == 0) {
            Pair pair = canFlow(row, col - 1, cache, rowLen, colLen, heights);//left
            sumPair = sumPair(sumPair, pair);
            if(sumPair.canFlowAtl && sumPair.canFlowPac){
                cache[row][col] = sumPair;
                return sumPair;
            }
        }
        if((row < rowLen-1 && heights[row+1][col] <= heights[row][col]) || row == rowLen-1) {
            Pair pair = canFlow(row + 1, col, cache, rowLen, colLen, heights);//bottom
            sumPair = sumPair(sumPair, pair);
            if(sumPair.canFlowAtl && sumPair.canFlowPac){
                cache[row][col] = sumPair;
                return sumPair;
            }
        }
        if((col < colLen-1 && heights[row][col+1] <= heights[row][col]) || col == colLen-1) {
            Pair pair = canFlow(row, col + 1, cache, rowLen, colLen, heights);//right
            sumPair = sumPair(sumPair, pair);
            if(sumPair.canFlowAtl && sumPair.canFlowPac){
                cache[row][col] = sumPair;
                return sumPair;
            }
        }

        cache[row][col] = sumPair;
        return sumPair;
    }

    private Pair sumPair(Pair pair1, Pair pair2) {
        return new Pair(pair1.canFlowPac || pair2.canFlowPac, pair1.canFlowAtl || pair2.canFlowAtl);
    }

    private static class Pair {
        boolean canFlowPac = false;
        boolean canFlowAtl = false;

        public Pair(boolean canFlowPac, boolean canFlowAtl) {
            this.canFlowPac = canFlowPac;
            this.canFlowAtl = canFlowAtl;
        }

        public Pair() {
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution417().pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4
                ,5},{5,1,1,2,4}}));
    }
}
