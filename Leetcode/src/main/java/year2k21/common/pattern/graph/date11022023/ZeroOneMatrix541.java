package year2k21.common.pattern.graph.date11022023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZeroOneMatrix541 {

    /**
     * First intuition will be, start from "One" and find distance of nearest "Zero", Time Complexity : O(mn * mn). For each cell do BFS
     *
     * Other approach is like Flood fill, start from "Zero"s and perform BFS one by one like Topo Sorting, Time Complexity : O(mn)
     * i.e. Each cell's distance will be updated only once as in "Shortest distance of unit undirected graph". Imagine diverging outwards happening from multiple centers (i.e. Zeros)
     *
     *  Problem is mix of Top Sorting + The Shortest distance of unit undirected graph
     */
    public int[][] updateMatrix(int[][] mat) {
        int rowLen = mat.length, colLen = mat[0].length;
        Queue<int[]> queue = new LinkedList<>(); //Queue storing int[2], i.e. [rowIndex, columnIndex]
        List<int[]> neighborDirections = Arrays.asList(new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1});
        for(int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if(mat[row][col] == 0) {
                    queue.add(new int[]{row, col}); //Start with ZERO cells like TopoSorting
                } else {
                    mat[row][col] = Integer.MAX_VALUE; //Set Rest all to MAX
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove();
            for(int[] neighborDirection : neighborDirections) {
                int neighborRowIndex = currentNode[0] + neighborDirection[0];
                int neighborColIndex = currentNode[1] + neighborDirection[1];
                if(neighborRowIndex < 0 || neighborRowIndex >= rowLen || neighborColIndex < 0 || neighborColIndex >= colLen ) {
                    continue;
                }
                int neighbor = mat[neighborRowIndex][neighborColIndex];
                if(neighbor != Integer.MAX_VALUE || neighbor == 0) {
                    continue;
                }
                if(mat[currentNode[0]][currentNode[1]] + 1 < neighbor) {
                    mat[neighborRowIndex][neighborColIndex] = mat[currentNode[0]][currentNode[1]] + 1;
                    queue.add(new int[]{neighborRowIndex, neighborColIndex});
                }
            }

        }

        return mat;
    }

    public static void main(String[] args) {
        ZeroOneMatrix541 sol = new ZeroOneMatrix541();
        //int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] input = {{0, 1, 1, 0}};
        int[][] updateMatrix = sol.updateMatrix(input);

        for (int[] matrix : updateMatrix) {
            System.out.println(Arrays.toString(matrix));
        }
    }
}
