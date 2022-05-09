package year2k21.common.pattern.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * For disconnected graph components
 * Template
 * for(int count=0; count<noOfVertices; count++) {//To cover all disconnected nodes
 *             if(visited[count] != 0) {//Visited => n times Not visited means, n disconnected components
 *                 continue;
 *             }
 *
 *             while(!DS.empty()){
 *                 for(int adjacentNode : adjList.get(currentNode)) {
 *                     if(visited[adjacentNode] == 0) {//Not visited
 *                      //DO logic
 *                     }
 *             }
 *   }
 */
public class Traversal {

    public static void bfs(List<List<Integer>> adjList) {
        int noOfVertices = adjList.size();
        int[] visited = new int[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        for(int count=0; count<noOfVertices; count++) {//To cover all disconnected nodes
            if(visited[count] != 0) {//Visited
                continue;
            }
            queue.add(count);
            visited[count] = 1;
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                System.out.print(currentNode + " ");
                for(int adjacentNode : adjList.get(currentNode)) {
                    if(visited[adjacentNode] == 0) {//Not visited
                        queue.offer(adjacentNode);
                        visited[adjacentNode] = 1;
                    }
                }
            }
        }
    }

    public static void dfs_Recursion(List<List<Integer>> adjList) {
        int noOfVertices = adjList.size();
        int[] visited = new int[noOfVertices];
        for(int count=0; count<noOfVertices; count++) {
            if(visited[count] != 0) {
                continue;
            }

            visited[count] = 1;
            dfs(count, visited, adjList);
        }
    }

    public static void dfs_Iteration(List<List<Integer>> adjList) {
        int noOfVertices = adjList.size();
        int[] visited = new int[noOfVertices];
        Stack<Integer> stack = new Stack<>();
        for(int count=0; count<noOfVertices; count++) {
            if(visited[count] != 0) {
                continue;
            }

            stack.add(count);
            visited[count] = 1;
            while (!stack.isEmpty()) {
                int currentNode = stack.pop();
                System.out.print(currentNode + " ");
                for (int neighbor : adjList.get(currentNode)) {
                    if(visited[neighbor] == 0){//Not visited
                        visited[neighbor] = 1;
                        stack.add(neighbor);
                    }
                }
            }
        }
    }

    private static void dfs(int node, int[] visited, List<List<Integer>> adjList) {
        System.out.print(node + " ");
        for(int neighbor: adjList.get(node)) {
            if(visited[neighbor] == 0) {//Not visited
                visited[neighbor] = 1;
                dfs(neighbor, visited, adjList);
            }
        }
    }

    /**
     * 1-2-3-4-1
     * 5-6-7-5
     * 8-9
     */
    public static void main(String[] args) {
        List<List<Integer>> adjList = Arrays.asList(new ArrayList<>(), Arrays.asList(2,4), Arrays.asList(1,3)
            , Arrays.asList(2,4), Arrays.asList(1,3), Arrays.asList(6,7), Arrays.asList(5,7), Arrays.asList(5,6),
                Arrays.asList(9), Arrays.asList(8));
        System.out.println("BFS:");
        bfs(adjList);
        System.out.println("DFS Recursion:");
        dfs_Recursion(adjList);
        System.out.println("DFS Iteration:");
        dfs_Iteration(adjList);
    }
}
