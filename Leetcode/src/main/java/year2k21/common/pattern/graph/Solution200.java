package year2k21.common.pattern.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution200 {

    /**
     * Find disconnected components => Check Traversal template section
     * Note: Leetcode solution DFS + no need of map, mark the char[][] cell to '#' or '0' to mark visited
     */
    public static int numIslands(char[][] grid) {//m*n
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;

        Map<String, Boolean> nodeVsIsVisitedMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                String startNode = getNodeString(row, column);
                if (nodeVsIsVisitedMap.get(startNode) != null) {//Visited
                    continue;
                }
                if (grid[row][column] == '0') {//Water node, so ignore
                    continue;
                }
                numIslands++;//Number of disconnected node

                nodeVsIsVisitedMap.put(startNode, true);
                queue.add(startNode);
                while (!queue.isEmpty()) {
                    String currentNode = queue.poll();
                    String[] split = currentNode.split("-");
                    int rowNow = Integer.parseInt(split[0]);
                    int columnNow = Integer.parseInt(split[1]);
                    if (ifNeighborIsLand(rowNow - 1, columnNow, grid)) {//top
                        String neighborNode = getNodeString(rowNow - 1, columnNow);
                        if (nodeVsIsVisitedMap.get(neighborNode) == null) {//Not visited
                            nodeVsIsVisitedMap.put(neighborNode, true);
                            queue.add(neighborNode);
                        }
                    }
                    if (ifNeighborIsLand(rowNow, columnNow - 1, grid)) {//left
                        String neighborNode = getNodeString(rowNow, columnNow - 1);
                        if (nodeVsIsVisitedMap.get(neighborNode) == null) {//Not visited
                            nodeVsIsVisitedMap.put(neighborNode, true);
                            queue.add(neighborNode);
                        }
                    }
                    if (ifNeighborIsLand(rowNow, columnNow + 1, grid)) {//right
                        String neighborNode = getNodeString(rowNow, columnNow + 1);
                        if (nodeVsIsVisitedMap.get(neighborNode) == null) {//Not visited
                            nodeVsIsVisitedMap.put(neighborNode, true);
                            queue.add(neighborNode);
                        }
                    }
                    if (ifNeighborIsLand(rowNow + 1, columnNow, grid)) {//bottom
                        String neighborNode = getNodeString(rowNow + 1, columnNow);
                        if (nodeVsIsVisitedMap.get(neighborNode) == null) {//Not visited
                            nodeVsIsVisitedMap.put(neighborNode, true);
                            queue.add(neighborNode);
                        }
                    }
                    /*
                    List<String> neighborNodes = new ArrayList<>();
                    if (ifNeighborIsLand(rowNow - 1, columnNow, grid)) {//top
                        neighborNodes.add(getNodeString(rowNow - 1, columnNow));

                    }
                    if (ifNeighborIsLand(rowNow, columnNow - 1, grid)) {//left
                        neighborNodes.add(getNodeString(rowNow, columnNow - 1));
                    }
                    if (ifNeighborIsLand(rowNow, columnNow + 1, grid)) {//right
                        neighborNodes.add(getNodeString(rowNow, columnNow + 1));
                    }
                    if (ifNeighborIsLand(rowNow + 1, columnNow, grid)) {//bottom
                        neighborNodes.add(getNodeString(rowNow + 1, columnNow));
                    }
                    neighborNodes.stream().filter(neighbor -> nodeVsIsVisitedMap.get(neighbor) == null)
                        .forEach(neighbor ->
                            {
                                nodeVsIsVisitedMap.put(neighbor, true);
                                queue.add(neighbor);
                            }
                        );
                     */
                }
            }
        }
        return numIslands;
    }

    static String getNodeString(int row, int col) {
        return row + "-" + col;
    }

    static boolean ifNeighborIsLand(int row, int col, char[][] grid) {
        try {
            if (grid[row][col] == '1') {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {//Water
            //Do Nothing
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
