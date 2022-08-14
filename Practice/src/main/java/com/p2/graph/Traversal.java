package com.p2.graph;

import java.util.*;

/**
 * Assuming each node is a character
 * Tips for Iterative(Recursive is little different, Don't worry Recursive DFS is intuitive and easy , no need of Tips):
 *      When encountered node newly, marked as visited and pushed to stack or Q
 *      When popped from stack or Q, print
 *
 * Note, use Boolean NodeVsVisited map instead of set for visited nodes, Reason is many problems might need similar DS, so easy to remember
 */
public class Traversal {

    private static Map<Character, List<Character>> adjList = new HashMap<>();
    private static Set<Character> visited = new HashSet<>();

    //Iterative using Q
    public static void bfs(char src) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            char current = queue.remove();
            System.out.println("Node:" + current);

            for (char neighbor : adjList.get(current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
    }

    public static void dfsRecursive(char node) {
        if(visited.contains(node)) {
            return;
        }

        System.out.println("Node:" + node);

        visited.add(node);
        for(char neighbor : adjList.get(node)) {
            dfsRecursive(neighbor);
        }
    }

    public static void dfsIterative(char src) {
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        visited.add(src);

        while (!stack.empty()) {
            char current = stack.pop();
            System.out.println("Node:" + current);

            for (char neighbor : adjList.get(current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                stack.push(neighbor);
                visited.add(neighbor);
            }
        }

    }

    public static void main(String[] args) {
        adjList.put('a', Arrays.asList('c', 'b'));
        adjList.put('b', Collections.singletonList('d'));
        adjList.put('c', new ArrayList<>());
        adjList.put('d', Collections.singletonList('e'));
        adjList.put('e', new ArrayList<>());
        adjList.put('f', new ArrayList<>());

        int disconnectedComponentCount = 0;

        for(char node : adjList.keySet()) {//The so-called outer-loop to tackle disconnected components
            if(visited.contains(node)){
                continue;
            }

            //This line actually enters for disconnected nodes only. This place can be used to count disconnected islands
            ++disconnectedComponentCount;

            //dfsRecursive(node);
            //dfsIterative(node);
            bfs(node);
        }

        System.out.println("Disconnected Components Count:" + disconnectedComponentCount);
    }
}
